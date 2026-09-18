# 模式、状态与文件通道

## 先找变化点，再选模式

| 示例 | 角色与观察点 | 测试 |
|---|---|---|
| Singleton / Singleton2 | DCL 中 volatile 防止错误发布；静态持有者按类初始化建立单例 | 8 个线程同时获取、身份一致 |
| Prototype | 浅复制共享 list；DeepClone 复制列表容器，元素 String 本身不可变 | 修改副本与原件的区别 |
| Builder | Director 控制步骤，BuilderA 构建部件；每次返回独立产品快照 | 两次构建、修改第一份不影响第二份 |
| FactoryMethod | Document 固定 render 流程，子类决定 Formatter 产品 | 原文/大写两种产品 |
| AbstractFactory | 同一个主题工厂创建一族 Button/Checkbox | 明暗两种产品族保持一致 |
| Bridge | CircleShape 的形状状态与 DrawingApi 绘制方式分离 | 缩放值实际传给绘制接口 |
| Composite | Employee 组合结构，拒绝循环和重复子节点 | 快照不可修改且不随原列表变化 |
| Facade | ShapeMaker 简化三个形状的调用 | 打包入口输出顺序 |
| Command | Action 执行返回逆操作，Invoker 持有后进先出历史 | 重复执行、逐层撤销、空历史 |
| ChainOfResponsibility | 不可变 Approver 链，首个额度足够的处理者响应 | 边界额度、传递、无人处理 |
| RecordTest | 值对象的组成字段与自动 equals | 不是责任链模式，独立运行 |

Builder 保留旧的 `Director.setBuilder/construct()` 教学调用方式，它有全局可变状态且不支持并发；新 main 使用 `construct(builder)` 显式传入。Composite 阻止环，但允许一个子节点被多个父节点引用，因此是无环组合结构，不宣称是带唯一父亲约束的组织管理系统。

Bridge 的历史方法名 `resizeByPercentage` 实际接收**倍数**：2.5 表示半径乘 2.5。为避免悄悄改变既有演示，保留语义并在测试固定这一点。形状示例使用有限、非负的尺寸，不是完整几何 API。

Command 示例只支持一个 Invoker 按顺序管理 Light 的状态，不保证跨 Invoker 并发撤销的正确性；自定义 Action 必须成功返回非空逆操作。工厂返回字符串示例产品，不把演示扩张为 GUI 框架。Prototype 的“深复制”只到当前列表容器；换成可变元素时需要额外复制。

## FileChannel 与 UTF-8

旧示例把每个字节直接转 char，跨缓冲区的中文会损坏；还固定写 `D:/HelloWorld.txt`，可能覆盖用户文件且留下旧尾部。

现在 `readUtf8(Path)` 使用 `Channels.newReader` 和严格 UTF-8 解码器，保留多字节字符跨缓冲区的状态；读路径不存在就失败，不创建文件。`writeNewUtf8(Path,String)` 先检查 UTF-16 可编码，再以 `CREATE_NEW` 打开新文件，通过 Writer 完整写入、flush、force 并关闭。父目录必须已存在。

两者以 **1,000,000 个 UTF-16 char** 为教学读取/写入上限；不是字节数，emoji 通常占两个 char。非法编码、超限、权限和磁盘错误会向调用者抛出，CLI 以非零退出码结束，不吞掉异常。I/O 期间失败可能留下本次新建的部分文件；这是单文件教学接口，不提供事务写入或自动删除失败文件的承诺。

测试在自己的临时目录中验证：1024 缓冲区边界的中文/emoji、真实字节内容、重复写保护、缺失文件、坏 UTF-8、孤立代理字符、大小限制、异常后的通道关闭；最后仅删除测试自己创建的文件。

练习：增加“复制到新文件”的命令时，先写已有目标不得改变、空文件、编码错误和关闭资源的测试，再考虑是否要提供原子替换模式。

命令行 `write <新路径>` 接收 UTF-8 标准输入，先完整解码并检查大小，再创建文件。真实 Windows 子进程检查发现 text 参数中的 emoji 可能被 JDK 的本地参数编码替换为问号，因此任意 Unicode 内容通过标准输入传递；保留三参数写入方式供简单文本演示。
