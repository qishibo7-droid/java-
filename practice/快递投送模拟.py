import random
import itertools  #全排列函数
# ==================== 可调参数 ====================
NODES = 10          # 节点总数（含起点）
START = 0           # 起点编号
SEED = 258        # 随机种子，固定后每次结果相同；改成 None 则每次不同
EXTRA_EDGE_P = 0.30 # 除生成树外，额外补边的概率（越大路网越密）
W_MIN, W_MAX = 3, 25  # 路长取值范围（整数）
Task_Pro=0.7   #一个节点有快递要送的概率
Task_Pro_1=0.7 #这个节点的快递是优先快递的概率
# =================================================   矩阵生成部分：Matrix是连通矩阵,Weight是路径矩阵，P是优先快递集合，O是普通快递集合，D是最短路径集合
import random
rng = random.Random(SEED)
Lite1, Lite2 = [], []   #Lite1行，Lite2列
order = list(range(NODES))  #待连接的节点
rng.shuffle(order)# 随机打乱：决定接入顺序
order.remove(START)   #删除起点
in_tree = [START]             # 起点先入树  ，in_tree代表已经接入的节点
for v in order:               # 每个新节点接一个已在树里的父节点
    u = rng.choice(in_tree)  #从已在树里的节点中随机抽一个当父节点 u
    Lite1.append(u)
    Lite2.append(v)
    in_tree.append(v)       #已经接入的节点多了v节点
# print(Lite1)
# print(Lite2)
Matrix=[[0 for _ in range(NODES)] for _ in range(NODES)]
for u, v in zip(Lite1, Lite2):
    Matrix[u][v] = 1
    Matrix[v][u] = 1
for i in range(NODES):
    for j in range(i + 1, NODES):#做到只便利上三角做随机连通
        if Matrix[i][j] == 1:#如果这个节点已经连通则跳过
            continue
        if rng.random() < EXTRA_EDGE_P:#按照EXTRA_EDGE_P概率随机连通
            Matrix[i][j] = 1
            Matrix[j][i] = 1
for i in Matrix:
    print(i)
Weight = [[0] * NODES for _ in range(NODES)]   # 权值必须另开一个矩阵
for i in range(NODES):
    for j in range(i + 1, NODES):#做到只便利上三角做随机连通
        if Matrix[i][j] == 1:
            w = rng.randint(W_MIN, W_MAX)
            Weight[i][j] = w
            Weight[j][i] = w
for i in Weight:
    print(i)
P, O = [], []
for v in range(NODES):
    if v == START:                          # 起点不发快递
        continue
    if sum(Matrix[v]) == 0:                 # 一个点都没连边：孤立点，不发
        continue
    if rng.random() < Task_Pro:             # 该点有快递
        if rng.random() < Task_Pro_1:       # 是优先件
            P.append(v)
        else:
            O.append(v)
INF = float("inf")
D = [[[INF, []] for _ in range(NODES)] for _ in range(NODES)]#创建一个新的矩阵用于存储最短路径
for i in range(NODES):
    D[i][i] = [0, [i]]
    for j in range(NODES):
        if i != j and Matrix[i][j] == 1:#先把原本的路径赋值进去
            D[i][j] = [Weight[i][j], [i, j]]
for k in range(NODES):  #将所有节点都作为中转节点挨个遍历
    for i in range(NODES):   #起始节点
        for j in range(NODES):  #终点
            d1, p1 = D[i][k]    #d1记录长度，p1记录路径
            if d1 == INF:
                continue
            d2, p2 = D[k][j]
            if d1 + d2 < D[i][j][0]:  #若缩短路径则赋值新长度，并且记录中转节点
                D[i][j] = [d1 + d2, p1 + p2[1:]]     # p2[1:] 去掉重复的 k
# =================================================        快递处理部分
def best_end(v, stops, begin):#固定终点的全排列函数
    others = [x for x in stops if x != v]            # 其余待送节点当中转
    if not others:
        return D[begin][v][1], D[begin][v][0]        # 没有中转，直达
    seq = min(itertools.permutations(others),
              key=lambda o: sum(D[a][b][0] for a, b in zip((begin,) + o, o + (v,))))#代码含义：itertools.permutations(others)全排列中间节点sum是求这种排序的时间，对每一段 (a, b) 查表取最短距离
    #zip是分配函数，总体函数意思是将首尾配对然后一次从D矩阵里取出距离，(begin,) + o是首节点加排列，o + (v,)是排列加尾节点
    #(begin,) + o        →  (0, 5, 6, 8)
    #o + (v,)            →  (5, 6, 8, 4)
    #这样可以完成（0，5），（5，6）等配对
    return [begin] + list(seq) + [v], sum(D[a][b][0] for a, b in zip((begin,) + seq, seq + (v,)))#代码含义：拼出完整停靠路线，并重算一次总时长
def best_route(stops, begin):#遍历 stops 集合，让每一个节点都作为一次终点，搜索最优解
    best = {}                                        #每条最优路线记录
    for v in stops:                                  # 固定终点
        best[v] = best_end(v, stops, begin)          # 全排列选中间顺序
    end = min(stops, key=lambda v: best[v][1])       # 全局最快终点
    return best, end, best[end]
def unpack(route):#解包路径：把停靠顺序展开成实际走过的节点序列
    nodes = []
    for a, b in zip(route, route[1:]):
        if nodes:
            nodes = nodes + D[a][b][1][1:]   # 中途每段去掉重复的起点 a
        else:
            nodes = nodes + D[a][b][1]       # 第一段带上起点
    return nodes
def find_passed(route, O):#找出路上顺便派送的普通快递
    nodes = unpack(route)
    passed = []
    for node in nodes[1:-1]:                 # 去掉首尾停靠点
        if node in O and node not in passed:
            passed.append(node)
    return passed
# =================================================   打印部分，实际处理问题的区域
print("P(优先):", P)
print("O(普通):", O)
for i in D:
    print(i)
if P:
    best, end, (stops, T) = best_route(P, START)  # 第一阶段：优先快递，起点是 START
    for v in P:
        print(f"终点{v}: 用时 {best[v][1]}, 顺序 {best[v][0]}")
    print(f"\n第一阶段最优: 终点 {end}, 总用时 {T} 分钟")
    print("停靠顺序:", stops)
    print("逐段:", [D[a][b][0] for a, b in zip(stops, stops[1:])])
    print("实际经过:", unpack(stops))
    print("顺路派送的普通快递:", find_passed(stops, O))
else:
    stops=[0]
free=find_passed(stops, O)
if free:                                            # 还有普通件要专门送
    best_1, end_1, (stops_1, T_1) = best_route(O, stops[-1])
    print(f"\n第二阶段最优: 终点 {end_1}, 总用时 {T_1} 分钟")
    print("停靠顺序:", stops_1)
    print("逐段:", [D[a][b][0] for a, b in zip(stops_1, stops_1[1:])])
else:                                            # 顺路全带完，没有第二阶段
    stops_1, T_1 = [], 0
    print("\n没有剩余普通快递，无需第二阶段")
full = unpack(stops) + unpack(stops_1)[1:]      #拼接完整路径
print(f"完整路径: {full}")
print(f"总耗时{T + T_1}")
#注释，这是理论最快的搜索算法，接下来的优化方向是：1.加入人数变量，通过人力成本软约束目标函数，搜索最优解人数以及路径。2。如果节点数量太多这套算法可能求解太慢，加入贪心算法和启发搜索只找近似最优解
#3.这套算法的核心是优先快递必须是理论最快，可以加入优先快递的迟到容忍度优化算法，即如果先送有些快递可以在容忍范围内加快整体运送时间那么就算最优解
