import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.Consumer;

public final class AlgorithmsTest {
    private static int checks;
    public static void main(String[] args) {
        List<Consumer<int[]>> algorithms = List.of(sort.BubbleSort::sort, sort.SelectionSort::sort,
                sort.InsertionSort::sort, sort.ShellSort::sort, sort.MergeSort::sort, sort.QuickSort::sort,
                sort.HeapSort::sort, sort.RadixSort::sort, sort.CountingSort::sort, sort.BucketSort::sort,
                others.HeapSort::sort, others.ShellSort::sort, others.ShellSort::sort1, others.ShellSort::sort2);
        Random random = new Random(912);
        for (Consumer<int[]> algorithm : algorithms) {
            for (int[] fixture : new int[][] {{}, {3}, {2, 1}, {1, 2, 3}, {3, 2, 1},
                    {4, 4, 4}, {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, -1, 1}}) verify(algorithm, fixture);
            for (int n = 0; n < 100; n++) {
                verify(algorithm, random.ints(n, -10, 11).toArray());
                verify(algorithm, random.ints(n).toArray());
            }
        }
        for (Consumer<int[]> fast : List.<Consumer<int[]>>of(sort.QuickSort::sort, sort.HeapSort::sort,
                sort.MergeSort::sort, sort.RadixSort::sort, sort.CountingSort::sort, sort.BucketSort::sort)) {
            verify(fast, java.util.stream.IntStream.range(0, 100_000).toArray());
            verify(fast, new int[100_000]);
        }
        List<Consumer<double[]>> doubles = List.of(others.InsertSort::insertSort, others.InsertSort::binaryInsertSort,
                others.InsertSort::shellSort, others.ExchangeSort::bubbleSort,
                a -> others.ExchangeSort.quickSort(a, 0, a.length - 1), others.MergeSort::mergeSort);
        for (Consumer<double[]> algorithm : doubles) {
            for (int n = 0; n < 100; n++) {
                double[] values = n == 0 ? new double[0] : random.doubles(n, -10, 10).toArray();
                if (n > 4) { values[0] = Double.NaN; values[1] = -0.0; values[2] = 0.0; values[3] = Double.NEGATIVE_INFINITY; values[4] = Double.POSITIVE_INFINITY; }
                double[] expected = values.clone(); Arrays.sort(expected); algorithm.accept(values);
                require(Arrays.equals(values, expected));
            }
        }
        double[] subrange = {9, 3, 1, 2, 8};
        others.ExchangeSort.quickSort(subrange, 1, 3);
        require(Arrays.equals(subrange, new double[] {9, 1, 2, 3, 8}));
        record Item(int key, int order) implements Comparable<Item> {
            @Override public int compareTo(Item other) { return Integer.compare(key, other.key); }
        }
        Item[] stable = {new Item(2, 0), new Item(1, 1), new Item(2, 2), new Item(1, 3)};
        others.InsertSort.insertSort(stable);
        require(stable[0].order() == 1 && stable[1].order() == 3 && stable[2].order() == 0);
        int[] original = {3, 2, 1}; sort.TestUtil.setTestArr(original); original[0] = 9;
        int[] copy = sort.TestUtil.getTestArr(); copy[0] = 8;
        require(Arrays.equals(sort.TestUtil.getTestArr(), new int[] {3, 2, 1}));
        heaps(random);
        require(grammar.nowcoder.Java49.isPrimeNumber(Integer.MAX_VALUE));
        require(!grammar.nowcoder.Java49.isPrimeNumber(Integer.MAX_VALUE - 1));
        require(grammar.nowcoder.Java11.getCM(Integer.MIN_VALUE, 0) == 0);
        System.out.println("AlgorithmsTest: " + checks + " assertions passed");
    }

    private static void heaps(Random random) {
        others.LeftIsHeap<Integer> left = new others.LeftIsHeap<>();
        others.LeftIsHeap<Integer> right = new others.LeftIsHeap<>();
        PriorityQueue<Integer> expected = new PriorityQueue<>();
        for (int i = 0; i < 2000; i++) {
            int value = random.nextInt(); expected.add(value);
            (i % 2 == 0 ? left : right).insert(value);
        }
        left.merge(right); left.merge(left);
        require(right.isEmpty() && left.size() == 2000);
        while (!expected.isEmpty()) require(expected.remove().equals(left.deleteMin()));
        require(left.isEmpty());
        rejects(java.util.NoSuchElementException.class, left::findMin);
        left.insert(1); left.makeEmpty(); require(left.size() == 0);
        rejects(NullPointerException.class, () -> left.insert(null));

        others.PairingHeap<Integer> heap = new others.PairingHeap<>();
        List<others.PairingHeap.Node<Integer>> handles = new ArrayList<>();
        for (int i = 0; i < 2000; i++) handles.add(heap.insert(random.nextInt(10000)));
        for (int i = 0; i < handles.size(); i++) {
            var handle = handles.get(i);
            if (i % 3 == 0) heap.updateKey(handle, handle.getKey() - 10000);
            expected.add(handle.getKey());
        }
        rejects(IllegalArgumentException.class, () -> heap.insert(handles.get(0)));
        rejects(IllegalArgumentException.class, () -> heap.updateKey(handles.get(0), Integer.MAX_VALUE));
        var foreign = new others.PairingHeap<Integer>().insert(1);
        rejects(IllegalArgumentException.class, () -> heap.updateKey(foreign, 0));
        others.PairingHeap.Node<Integer> removed = null;
        while (!expected.isEmpty()) {
            require(expected.peek().equals(heap.findMin().getKey()));
            removed = heap.extractMin(); require(expected.remove().equals(removed.getKey()));
        }
        require(heap.isEmpty() && heap.size() == 0 && heap.extractMin() == null);
        var stale = removed;
        rejects(IllegalArgumentException.class, () -> heap.updateKey(stale, -1));
        require(heap.insert(stale) == stale && heap.extractMin() == stale);
        others.PairingHeap<String> strings = new others.PairingHeap<>();
        strings.insert("z"); strings.insert("a"); strings.merge(new others.PairingHeap.Node<>("b"));
        require(strings.extractMin().getKey().equals("a"));
        require(strings.extractMin().getKey().equals("b"));
        require(strings.extractMin().getKey().equals("z"));
    }

    private static void verify(Consumer<int[]> algorithm, int[] input) {
        int[] actual = input.clone(), expected = input.clone();
        Arrays.sort(expected); algorithm.accept(actual); require(Arrays.equals(actual, expected));
    }
    private static void require(boolean condition) { checks++; if (!condition) throw new AssertionError(); }
    private static void rejects(Class<? extends Throwable> type, Runnable task) {
        try { task.run(); } catch (Throwable error) { require(type.isInstance(error)); return; }
        throw new AssertionError("Expected " + type.getSimpleName());
    }
}
