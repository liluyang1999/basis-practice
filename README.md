# Java 基础练习：从能运行到能解释

包含 50 道语法练习、10 种整数排序、浮点与泛型排序、左式堆与配对堆、树旋转、设计模式和文件通道示例。保留原有包名与练习编号；原仓库没有 Java32，不虚构补题。

## 离线构建与运行

需要已安装的 **JDK 19 或更新版本、PowerShell 7**，`java`、`javac`、`jar` 来自同一个 JDK 并在 PATH。保留原 IntelliJ 项目的 Java 19 源码/字节码目标；本次实际验证使用 Windows、Oracle JDK 25.0.2。JDK 19 的实际运行环境未验证。

```powershell
./scripts/build.ps1 -Test
java -cp build/basis-practice.jar sort.QuickSort 32 42
'6 8' | java -cp build/basis-practice.jar grammar.nowcoder.Java11
java -cp build/basis-practice.jar pattern.behavioral_pattern.Command
```

构建只用 JDK，自带断言测试不依赖 JUnit、Maven 或 Gradle，也不下载软件。`-Test` 在临时目录编译全部源码和测试，以 `--release 19 -encoding UTF-8 -Xlint:all -Werror` 检查，然后通过实际 JAR 的 classpath 启动测试与示例。失败不替换上一次成功的 JAR，临时编译目录在结束时清理。

每个练习有自己的入口，没有统一 `Main-Class`；因此使用 `java -cp ... 完整类名`，而非 `java -jar`。`build/` 为忽略的生成目录，产物只包含项目类，不含测试、源码或第三方包。

## 学习路线

1. [语法练习目录](docs/exercises.md)：输入契约、知识点与每题可执行用例。
2. [算法与数据结构](docs/algorithms.md)：排序不变量、复杂度、稳定性、堆的所有权和回归练习。
3. [设计模式与文件 I/O](docs/patterns-and-io.md)：参与者、可变状态、错误处理和 UTF-8。
4. [维护与验证记录](docs/maintenance.md)：修复证据、兼容变化、检查边界及后续练习。

排序入口接受 `[数量 0..10000] [随机种子]`，默认 32、42；输出最多前 32 个数，但会核对完整结果。耗时仅演示计时 API，不是严谨性能排名。

文件示例必须给出路径：

```powershell
$OutputEncoding = [Text.UTF8Encoding]::new($false)
'你好，Java 😀' | java -cp build/basis-practice.jar nio.FileChannelTest write './new-note.txt'
java -cp build/basis-practice.jar nio.FileChannelTest read './new-note.txt'
```

`write` 仅创建新文件；同名文件存在就失败。运行示例前选择自己的新路径。控制台显示中文还取决于终端编码，文件内容始终为 UTF-8。省略 text 参数会读取 UTF-8 标准输入；Windows 启动器可能损坏命令行 text 参数中的非本地字符，含 emoji 时请用上面的管道方式。PowerShell 管道会附加换行。
