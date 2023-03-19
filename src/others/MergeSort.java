package others;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        double[] array = {8.2, 1.3, 33.2, 2.8, 2, 6, 3, 5, 2.2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(double[] array) {
        double[] temp = new double[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private static void mergeSort(double[] array, int left, int right, double[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    private static void merge(double[] array, int left, int mid, int right, double[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        //mid两边均为子问题已排好序的数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }

        t = 0;
        while(left <= right) {
            array[left++] = temp[t++];
        }
    }

}
