package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        SelectionSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        int step = arr.length / 3;
        while (step >= 1) {
            for (int i = 0; i < step; i++) {
                sort(arr, i, step);
            }
            step = step >> 1;
        }
    }

    private static void sort(int[] arr, int begin, int step) {
        for (int i = begin + step; i < arr.length; i = i + step) {
            for (int j = i - step; j >= begin; j = j - step) {
                if (arr[j] > arr[j + step]) {
                    arr[j] = arr[j] ^ arr[j + step];
                    arr[j + step] = arr[j] ^ arr[j + step];
                    arr[j] = arr[j] ^ arr[j + step];
                }
            }
        }
    }
}
