package sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        QuickSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int[] countingArr = new int[max - min + 1];
        for (int i : arr) {
            int diff = i - min;
            countingArr[diff]++;
        }

        for (int i = 1; i < countingArr.length; i++) {
            countingArr[i] = countingArr[i] + countingArr[i - 1];
        }

        int pos = 0;
        for (int i = 0; i < countingArr.length; i++) {
            int count;
            if (i == 0) {
                count = countingArr[i];
            } else {
                count = countingArr[i] - countingArr[i - 1];
            }

            for (int j = 0; j < count; j++) {
                arr[pos++] = min + i;
            }
        }
    }

}
