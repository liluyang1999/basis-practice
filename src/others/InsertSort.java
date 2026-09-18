package others;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        double[] values = {2.2, 3, 1, -0.0, Double.NaN};
        binaryInsertSort(values);
        System.out.println(Arrays.toString(values));
    }

    public static void insertSort(double[] array) { gapInsert(array, 1); }

    public static void shellSort(double[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) gapInsert(array, gap);
    }

    private static void gapInsert(double[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            double value = array[i];
            int j = i;
            while (j >= gap && Double.compare(array[j - gap], value) > 0) {
                array[j] = array[j - gap]; j -= gap;
            }
            array[j] = value;
        }
    }

    public static void binaryInsertSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double value = array[i];
            int low = 0, high = i;
            // Upper bound places equal elements after earlier ones (stable).
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (Double.compare(array[mid], value) <= 0) low = mid + 1;
                else high = mid;
            }
            System.arraycopy(array, low, array, low + 1, i - low);
            array[low] = value;
        }
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T value = arr[i];
            int j = i;
            while (j > 0 && value.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1]; j--;
            }
            arr[j] = value;
        }
    }
}
