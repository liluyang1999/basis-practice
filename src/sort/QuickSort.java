package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        QuickSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }


    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int leftBound, int rightBound) {
        int pivot = leftBound;
        int left = leftBound, right = rightBound;
        //循环到左指针与右指针相等结束
        while (left < right) {
            if (left == pivot) {
                //此时基准数在左指针
                while (arr[right] >= arr[left] && left < right) {
                    right--;
                }
                if (arr[right] < arr[pivot] && left < right) {
                    arr[right] = arr[pivot] ^ arr[right];
                    arr[pivot] = arr[right] ^ arr[pivot];
                    arr[right] = arr[right] ^ arr[pivot];
                    pivot = right;
                    left++;
                }
            } else {
                //此时基准数在右指针
                while (arr[left] < arr[pivot] && left < right) {
                    left++;
                }
                if (arr[left] >= arr[pivot] && left < right) {
                    arr[left] = arr[pivot] ^ arr[left];
                    arr[pivot] = arr[left] ^ arr[pivot];
                    arr[left] = arr[left] ^ arr[pivot];
                    pivot = left;
                    right--;
                }
            }
            if (left == right) {
                sort(arr, leftBound, pivot - 1);
                sort(arr, pivot + 1, rightBound);
            }
        }

    }

}

