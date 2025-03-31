# SenDB

SenDB 是一个基于 Java 实现的简易、轻量级数据库系统，其部分原理参照自 MySQL、PostgreSQL 等主流数据库。YSDB 旨在提供一个简单易用的数据库解决方案，支持多种高级数据库特性，适用于学习、研究和小规模应用场景。

## 核心特性

SenDB 实现了以下核心功能，确保数据管理的可靠性和高效性：

- **数据可靠性与恢复机制**：通过日志和检查点技术，确保数据的持久性和故障恢复能力。
- **并发控制**：
    - 支持**两段锁协议（2PL）**，实现可串行化调度，确保事务的隔离性和一致性。
    - 提供**多版本并发控制（MVCC）**，支持高效的读写并发操作，避免锁争用。
- **事务隔离级别**：
    - 支持 **读提交（Read Committed）** 和 **可重复读（Repeatable Read）** 两种隔离级别，满足不同场景下的数据一致性需求。
- **死锁处理**：内置死锁检测与处理机制，自动解除死锁并回滚相关事务。
- **表与字段管理**：提供简单的表和字段管理功能，支持基本的数据库模式操作。
- **SQL 解析**：实现了基础的 SQL 解析功能，支持类 SQL 语法（由于未实现完整的词法分析和自动机，功能较为简化）。
- **网络通信**：基于 Socket 实现了数据库的客户端-服务器架构，支持远程访问和操作。

## 快速开始

### 环境要求
- JDK 8 或更高版本
- Maven 3.x

### 编译与运行

1. **编译源码**  
   在项目根目录下执行以下命令，编译源码：
   ```shell
   mvn compile
   ```

2. **创建数据库**  
   使用以下命令创建数据库，数据库文件将存储在指定路径（例如 `/tmp/sendb`）：
   ```shell
   mvn exec:java -Dexec.mainClass="com.fengyusen.sendb.backend.Launcher" -Dexec.args="-create /tmp/sendb"
   ```

3. **启动数据库服务**  
   启动数据库服务，默认监听本机的 `9627` 端口：
   ```shell
   mvn exec:java -Dexec.mainClass="com.fengyusen.sendb.backend.Launcher" -Dexec.args="-open /tmp/sendb"
   ```

4. **启动客户端**  
   在新的终端中启动客户端，连接到数据库服务：
   ```shell
   mvn exec:java -Dexec.mainClass="com.fengyusen.sendb.client.Launcher"
   ```
   客户端将启动一个交互式命令行界面，您可以在此输入类 SQL 语句并查看执行结果。

## 架构设计

SenDB 的设计遵循现代数据库系统的核心原则，主要包括以下模块：

- **存储管理**：负责数据的持久化存储与恢复，支持高效的页面管理和缓存机制。
- **事务管理**：通过两段锁协议和 MVCC 实现事务的并发控制与隔离。
- **SQL 解析**：提供基础的 SQL 解析功能，支持简单的查询与数据操作。
- **网络通信**：基于 Socket 实现客户端与服务端的通信，支持远程数据库访问。

## 适用场景

SenDB 适用于以下场景：
- 数据库原理学习与教学
- 小型项目的数据存储与管理
- 数据库相关技术的原型开发与验证

## 未来规划

SenDB 将持续优化和扩展，未来的开发计划包括：
- 支持更多 SQL 语法（如 JOIN、GROUP BY 等）
- 实现更高效的查询优化器
- 提供分布式事务支持
- 增强数据安全性与权限管理

## 贡献与反馈

欢迎贡献代码、提交问题或提出建议！请通过 [GitHub Issues](https://github.com/fengyusen/SenDB/issues) 提交反馈。

---

通过 SenDB，您可以深入理解数据库的核心原理，并体验一个轻量级数据库系统的设计与实现。希望 SenDB 能为您的学习和开发带来帮助！
