import java.util.Arrays;
import java.util.function.Consumer;

/** Reproductions of defects found in the original exercises; no test framework needed. */
public final class RegressionTest {
    private static int failures;

    public static void main(String[] args) {
        check("selection self-swap", () -> ints(sort.SelectionSort::sort, 1, 2, 3));
        check("shell two elements", () -> ints(sort.ShellSort::sort, 2, 1));
        check("heap implementation", () -> ints(sort.HeapSort::sort, 3, 1, 2));
        check("radix signed values", () -> ints(sort.RadixSort::sort, 3, -1, 2));
        check("counting empty", () -> ints(sort.CountingSort::sort));
        check("bucket empty", () -> ints(sort.BucketSort::sort));
        check("legacy heap", () -> ints(others.HeapSort::sort, 9, 3, 8, 2, 1, 7, 4));
        check("legacy shell", () -> ints(others.ShellSort::sort1, 9, 3, 8, 2, 1, 7, 4));
        check("generic insertion", () -> {
            Integer[] a = {3, 2, 1};
            others.InsertSort.insertSort(a);
            if (!Arrays.equals(a, new Integer[] {1, 2, 3})) throw new AssertionError(Arrays.toString(a));
        });
        check("binary insertion", () -> {
            double[] a = {1, 2, 3, 4};
            others.InsertSort.binaryInsertSort(a);
            if (!Arrays.equals(a, new double[] {1, 2, 3, 4})) throw new AssertionError(Arrays.toString(a));
        });
        check("leftist heap implementation", () -> {
            others.LeftIsHeap<Integer> h = new others.LeftIsHeap<>();
            h.insert(3); h.insert(1);
            if (h.isEmpty() || !Integer.valueOf(1).equals(h.deleteMin())) throw new AssertionError();
        });
        check("one is not prime", () -> {
            if (grammar.nowcoder.Java14.isPrimeNumber(1)) throw new AssertionError();
        });
        if (failures > 0) throw new AssertionError(failures + " regression cases failed");
        System.out.println("RegressionTest: 12 cases passed");
    }

    private static void ints(Consumer<int[]> algorithm, int... input) {
        int[] expected = input.clone();
        Arrays.sort(expected);
        algorithm.accept(input);
        if (!Arrays.equals(input, expected)) throw new AssertionError(Arrays.toString(input));
    }

    private static void check(String name, Runnable test) {
        try { test.run(); }
        catch (RuntimeException | AssertionError error) {
            failures++;
            System.err.println(name + ": " + error);
        }
    }
}
