package others;

import java.util.Arrays;

public class ExchangeSort {
    public static void main(String[] args) {
        double[] values = {2, 3, 1.2, -0.0, Double.NaN};
        quickSort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }

    public static void bubbleSort(double[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (Double.compare(array[i], array[i + 1]) > 0) swap(array, i, i + 1);
            }
        }
    }

    /** Sort the inclusive range; (0,-1) is the valid range of an empty array. */
    public static void quickSort(double[] array, int low, int top) {
        if (low < 0 || top >= array.length || low > top + 1) throw new IndexOutOfBoundsException();
        quick(array, low, top);
    }

    private static void quick(double[] arr, int low, int high) {
        while (low < high) {
            double pivot = arr[low + (high - low) / 2];
            int less = low, cursor = low, greater = high;
            while (cursor <= greater) {
                int compared = Double.compare(arr[cursor], pivot);
                if (compared < 0) swap(arr, less++, cursor++);
                else if (compared > 0) swap(arr, cursor, greater--);
                else cursor++;
            }
            if (less - low < high - greater) {
                quick(arr, low, less - 1); low = greater + 1;
            } else {
                quick(arr, greater + 1, high); high = less - 1;
            }
        }
    }

    private static void swap(double[] arr, int a, int b) {
        double value = arr[a]; arr[a] = arr[b]; arr[b] = value;
    }
}
