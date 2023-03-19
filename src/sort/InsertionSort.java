package sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        InsertionSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j >= 1 && (temp < arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
