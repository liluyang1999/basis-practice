package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

    private static final int bucketCapacity = 10;

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        BucketSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int bucketNum = (max - min + 1) / bucketCapacity + 1;
        List<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int val : arr) {
            int index = (val - min + 1) / bucketCapacity;
            buckets.get(index).add(val);
        }

        int pos = 0;
        for (List<Integer> bucket : buckets) {
            Integer[] bucketArr = bucket.toArray(new Integer[0]);
            Arrays.sort(bucketArr);
            for (int i : bucketArr) {
                arr[pos++] = i;
            }
        }
    }

}
