import random
# ==================== 可调参数 ====================
NODES = 10          # 节点总数（含起点）
START = 0           # 起点编号
SEED = 2024         # 随机种子，固定后每次结果相同；改成 None 则每次不同
EXTRA_EDGE_P = 0.70 # 除生成树外，额外补边的概率（越大路网越密）
W_MIN, W_MAX = 3, 25  # 路长取值范围（整数）
Task_Pro=0.5   #一个节点有快递要送的概率
Task_Pro_1=0.3 #这个节点的快递是优先快递的概率
# =================================================
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
print(Lite1)
print(Lite2)
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
print("P(优先):", P)
print("O(普通):", O)




