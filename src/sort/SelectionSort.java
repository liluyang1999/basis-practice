package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) throws InterruptedException {
        long timestamp1 = System.currentTimeMillis();
        SelectionSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int choice = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[choice] > arr[j]) {
                    choice = j;
                }
            }
            arr[choice] = arr[choice] ^ arr[i];
            arr[i] = arr[choice] ^ arr[i];
            arr[choice] = arr[choice] ^ arr[i];
        }
    }

}
