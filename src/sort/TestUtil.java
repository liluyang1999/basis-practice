package sort;

import java.util.Objects;
import java.util.Random;

public class TestUtil {
    private static volatile int[] testArr = randomArray(10_000, 42);

    public static int[] getTestArr() { return testArr.clone(); }
    public static void setTestArr(int[] arr) { testArr = Objects.requireNonNull(arr).clone(); }

    public static int[] randomArray(int count, long seed) {
        if (count < 0) throw new IllegalArgumentException("count must be nonnegative");
        return new Random(seed).ints(count, -10_000, 10_001).toArray();
    }

    public static void main(String[] args) { SortDemo.run("QuickSort", QuickSort::sort, args); }
}
