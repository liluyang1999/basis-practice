package sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        SortDemo.run("BucketSort", BucketSort::sort, args);
    }

    public static void sort(int[] arr) {
        if (arr.length < 2) return;
        int min = arr[0], max = arr[0];
        for (int value : arr) { min = Math.min(min, value); max = Math.max(max, value); }
        int count = Math.min(arr.length, 1024);
        long width = ((long) max - min) / count + 1;
        List<List<Integer>> buckets = new ArrayList<>(count);
        for (int i = 0; i < count; i++) buckets.add(new ArrayList<>());
        for (int value : arr) buckets.get((int) (((long) value - min) / width)).add(value);
        int position = 0;
        for (List<Integer> bucket : buckets) {
            bucket.sort(null);
            for (int value : bucket) arr[position++] = value;
        }
    }
}
