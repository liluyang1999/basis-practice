package sort;

import java.util.Arrays;
import java.util.function.Consumer;

/** A repeatable illustration; a single wall-clock sample is not a benchmark. */
public final class SortDemo {
    private SortDemo() { }

    public static void run(String name, Consumer<int[]> algorithm, String[] args) {
        if (args.length > 2) throw new IllegalArgumentException("Usage: [count 0..10000] [seed]");
        int count = args.length > 0 ? Integer.parseInt(args[0]) : 32;
        long seed = args.length > 1 ? Long.parseLong(args[1]) : 42;
        if (count < 0 || count > 10_000) throw new IllegalArgumentException("count must be 0..10000");
        int[] values = TestUtil.randomArray(count, seed);
        int[] expected = values.clone();
        Arrays.sort(expected);
        long start = System.nanoTime();
        algorithm.accept(values);
        long elapsed = System.nanoTime() - start;
        if (!Arrays.equals(values, expected)) throw new AssertionError(name + " produced an incorrect result");
        System.out.println(name + ": count=" + count + ", seed=" + seed + ", elapsed(ns)=" + elapsed);
        System.out.println(Arrays.toString(Arrays.copyOf(values, Math.min(count, 32))));
        if (count > 32) System.out.println("(first 32 values; complete result verified)");
    }
}
