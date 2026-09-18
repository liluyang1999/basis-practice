# 算法与数据结构学习手册

## 共同契约与实验方式

`sort.*.sort(int[])` 原地升序、无输出，支持空数组、重复值、负数和整个 `int` 范围；`null` 是调用错误并抛出 `NullPointerException`。别把空数组和未提供数组混为一谈。

先手算 `[3, 1, 2, 1]` 的每一步，再读代码，最后用同一份输入的副本对照 `Arrays.sort`。`TestUtil.getTestArr()` 和 `setTestArr()` 都防御性复制，某次排序不会污染后续实验。`AlgorithmsTest` 还比较随机数组、极端整数与 100,000 元素的有序/相等数组。

| 实现 | 核心不变量 | 时间与额外空间 | 稳定性 |
|---|---|---|---|
| BubbleSort | 每轮末尾确定一个最大值 | O(n²)，O(1) | 稳定 |
| SelectionSort | 前缀已经是最小若干元素 | O(n²)，O(1) | 不稳定 |
| InsertionSort | 插入前的前缀有序 | 最坏 O(n²)，O(1) | 稳定 |
| ShellSort | 每个 gap 分组有序，最终 gap=1 | 此折半序列最坏 O(n²)，O(1) | 不稳定 |
| MergeSort | 合并两个已排序子区间 | O(n log n)，峰值 O(n) | 稳定 |
| QuickSort | 小于、等于、大于 pivot 三段 | 平均 O(n log n)，最坏 O(n²)；栈 O(log n) | 不稳定 |
| HeapSort | 未输出区间为最大堆 | O(n log n)，O(1) | 不稳定 |
| CountingSort | 桶计数之和等于输入数量 | 密集范围 O(n+k)、O(k)；过宽时转堆排序 | 数值重建，不提供关联记录的稳定契约 |
| BucketSort | 桶间有序，桶内用 JDK 排序 | 最坏 O(n log n)，O(n+b)；b≤1024 | 整数值接口不提供关联记录契约 |
| RadixSort | 每一遍稳定排序一个字节 | 固定 4 遍 O(n+256)，O(n+256) | 稳定 |

选择排序不能在同一位置用 XOR 交换：`a ^= a` 会把元素置零。临时变量交换同时适用于自交换和重复值。

希尔排序要覆盖长度 2；原来的 `n/3` 会直接跳过循环。堆排序的孩子边界使用当前堆长度，不能把已经输出的尾部放回堆。

快速排序取中间位置的值，三向划分一次跳过所有等值元素；只递归较小区间、循环处理较大区间，所以限制了栈深度。这并不消除对抗性数据下的 O(n²) 时间。

计数排序先用 `long` 计算范围；超过 1,000,000 个计数槽时调用本项目堆排序，避免溢出与巨额分配。这是明确的混合策略。桶排序最多 1,024 桶，以 `long` 计算宽度和索引；性能随数据分布变化，不能只凭名称断言线性时间。

基数排序先翻转符号位 `value ^ Integer.MIN_VALUE`，使转换后的无符号字节次序与有符号整数次序一致；从末尾向前分配位置保持每一遍稳定。

`others` 保留历史练习入口：整数 HeapSort 委托唯一的维护实现；ShellSort 保留交换、按组移动、整体移动三种版本。六个 `double[]` 排序均用 `Double.compare`，与 `Arrays.sort(double[])` 一样把 `-0.0` 放在 `+0.0` 前、NaN 放在最后。泛型插入排序比较保存的插入值，不能比较已经被移动覆盖的位置。

## 左式堆

`LeftIsHeap<T>` 是最小堆，`findMin/deleteMin` 在空堆上抛 `NoSuchElementException`。节点的空路径长满足 `rank(left) >= rank(right)`；空子树 rank=-1，叶子 rank=0。合并后交换左右孩子并重新计算 rank，使右路径较短。

`left.merge(right)` 转移节点并清空 right；与自身合并无操作。`makeEmpty` 清空堆，`size` 记录元素数。键必须非空且有一致的自然序；插入后的可变键不能在堆外修改。该类不保证线程安全。

## 配对堆

```java
PairingHeap<Integer> heap = new PairingHeap<>();
PairingHeap.Node<Integer> handle = heap.insert(8);
heap.insert(3);
heap.updateKey(handle, 1);
System.out.println(heap.extractMin().getKey()); // 1
```

`insert` 返回新元素的句柄，而非当前根。`updateKey` 只允许当前堆的有效句柄降键；增键、重复插入、别的堆的句柄、已经取出的句柄都报错。`extractMin` 返回完全脱离树的节点；空堆返回 null，保留原接口习惯。取出的节点可以重新插入。

删除最小值先把孩子从左到右两两合并，再从右到左合并结果。这里用列表保存第一遍结果，让两个阶段和指针所有权易于检查。`merge(Node)` 保留历史入口，但仅接受未归属任何堆的单节点，不能把另一个堆的活根直接接进来。

`TreapNode` 只示范旋转，**不是完整 Treap 容器**。构造器保存键与优先级；旋转返回新子树根，调用者必须写 `root = root.left_rotate(root)`，并负责接回父节点。测试确认旋转不丢失中间子树。

## 动手练习

1. 给选择排序恢复 XOR 自交换，先观察 `RegressionTest` 失败，再解释丢失的是值还是顺序。
2. 在随机数据中插入 MIN_VALUE/MAX_VALUE，解释计数、桶、基数三种算法分别怎样处理。
3. 给泛型排序加上重复键和序号，检验稳定性；仅比较整数无法观察稳定性。
4. 手画配对堆降键与两遍合并前后的 `previous/child/sibling`，对照 PriorityQueue 的出队序列。
5. 扩展 Treap 插入前，先写二叉搜索序与优先级堆序不变量测试，不把节点旋转练习误认为完整容器。
