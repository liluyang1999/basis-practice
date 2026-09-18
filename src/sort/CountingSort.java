package sort;

public class CountingSort {
    public static void main(String[] args) {
        SortDemo.run("CountingSort", CountingSort::sort, args);
    }

    public static void sort(int[] arr) {
        if (arr.length < 2) return;
        int min = arr[0], max = arr[0];
        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        long range = (long) max - min + 1;
        // Counting is useful for dense ranges, not a multi-gigabyte allocation.
        if (range > 1_000_000) {
            HeapSort.sort(arr);
            return;
        }
        int[] counts = new int[(int) range];
        for (int value : arr) counts[(int) ((long) value - min)]++;
        int position = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int count = counts[i]; count > 0; count--) arr[position++] = min + i;
        }
    }
}
