# java-

记录java学习进度上传所学代码

**当前阶段**：第一阶段 · 基础地基期（2026.09 — 2027.02）
**起始时间**：2026 年 9 月

---

## 一、进度总览

| 阶段 | 时间 | 目标 | 状态 |
|---|---|---|---|
| **第一阶段** | 2026.09 — 2027.02 | Java SE、SQL、计算机基础、算法启动 | 🔄 进行中 |
| 第二阶段 | 2027.03 — 2027.08 | Hadoop/Hive 数仓入门、第一段实习 | ⬜ 未开始 |
| 第三阶段 | 2027.09 — 2028.02 | Spark、核心大项目、八股与算法一轮 | ⬜ 未开始 |
| 第四阶段 | 2028.03 — 2029.06 | 暑期实习、转正、秋招 | ⬜ 未开始 |

### 第一阶段任务清单

- [x] 开始 Java SE 学习，建立 GitHub 提交习惯
- [ ] Java SE：面向对象、集合、异常、IO
- [ ] MySQL 与 SQL 强化（牛客题库初阶+中阶约 100 题）
- [ ] Linux 常用命令与 Git 工作流
- [ ] Java 多线程、JVM 概念级理解
- [ ] LeetCode 累计 80 题
- [ ] 产出：Java 小工具仓库

---

## 二、学习记录

| 日期 | 内容 | 对应代码 | 详细笔记 |
|---|---|---|---|
| 2026-09-11 | Java 基础语法结构、基本数据类型与取值范围、二进制补码、与 Python 的对比 | `src/LearningData1.java` | [学习记录](notes/2026-09-11-学习记录.md) |
| 2026-09-12 | 浮点类型 float/double 与精度问题、char 字符类型与转义字符、byte 与 char 不可互转、二元数值提升与整数除法截断 | `src/LearningData2.java`、`src/LearningData3.java`、`src/LearningData4.java` | [学习记录](notes/2026-09-12-学习记录.md) |
| 2026-09-13 | 自增自减、复合赋值运算符、位运算符与位移、关系与逻辑运算符、短路与非短路、运算符优先级 | `src/LearningData5.java`、`src/LearningData6.java`、`src/LearningData7.java` | [学习记录](notes/2026-09-13-学习记录.md) |
| 2026-09-14 | 代码块作用域、if/else if/else 选择结构、switch 与 break 穿透 | `src/LearningData8.java` | [学习记录](notes/2026-09-14-学习记录.md) |

---

## 三、仓库结构

```
java-/
├── README.md                       本文件：进度总览与导航
├── src/
│   ├── LearningData1.java          基础语法与基本数据类型
│   ├── LearningData2.java          浮点类型与精度问题
│   ├── LearningData3.java          char 字符类型与转义字符
│   ├── LearningData4.java          二元数值提升、整数除法与字符串拼接
│   ├── LearningData5.java          自增自减与复合赋值运算符
│   ├── LearningData6.java          位运算符与位移
│   ├── LearningData7.java          关系、逻辑运算符与三元运算符
│   └── LearningData8.java          代码块作用域与选择结构（if / switch）
└── notes/
    ├── 2026-09-11-学习记录.md
    ├── 2026-09-12-学习记录.md
    ├── 2026-09-13-学习记录.md
    └── 2026-09-14-学习记录.md
```

---

## 四、开发环境

| 项目 | 版本 / 说明 |
|---|---|
| JDK | Java 24（`javac` 24.0.1） |
| IDE | IntelliJ IDEA |
| 编译编码 | UTF-8（源码含中文注释，编译时必须指定 `-encoding UTF-8`） |

---

## 五、说明

- 提交信息使用中文，格式参照 `feat:` / `fix:` / `docs:` / `chore:` 前缀，便于回溯每个阶段做了什么。
- 学习记录存放在 `notes/` 目录，命名格式为 `YYYY-MM-DD-学习记录.md`。
- `out/`、`.idea/`、`*.iml`、`*.bak` 均已在 `.gitignore` 中排除，不入库。
