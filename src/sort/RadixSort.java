package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        RadixSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }


}
