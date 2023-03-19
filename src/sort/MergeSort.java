package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        MergeSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1) + "ms");
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int center = leftBound + (rightBound - leftBound) / 2;
            sort(arr, leftBound, center);
            sort(arr, center + 1, rightBound);
            merge(arr, leftBound, center, rightBound);
        }
    }

    private static void merge(int[] arr, int leftBound, int center, int rightBound) {
        int[] temp = new int[rightBound - leftBound + 1];
        int tempPtr = 0;
        int leftArrPtr = leftBound, rightArrPtr = center + 1;
        while (leftArrPtr <= center && rightArrPtr <= rightBound) {
            if (arr[leftArrPtr] <= arr[rightArrPtr]) {
                temp[tempPtr++] = arr[leftArrPtr];
                leftArrPtr++;
            } else {
                temp[tempPtr++] = arr[rightArrPtr];
                rightArrPtr++;
            }
        }

        if (leftArrPtr <= center) {
            for (int i = leftArrPtr; i <= center; i++) {
                temp[tempPtr++] = arr[i];
            }
        }
        if (rightArrPtr <= rightBound) {
            for (int i = rightArrPtr; i <= rightBound; i++) {
                temp[tempPtr++] = arr[i];
            }
        }

        System.arraycopy(temp, 0, arr, leftBound, temp.length);
    }

}

