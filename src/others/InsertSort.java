package others;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        double[] array = {2.2, 3.0,1,8.2,9.3,4,3.1, 10, 20.0, 17, 23, 12, 9, 3, 0, 1};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j - 1] > array[j]) {
                    double temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void shellSort(double[] array) {
        for (int gap = array.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < array.length; i += gap) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j + gap] < array[j]) {
                        double temp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public static void binaryInsertSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            int top = i;
            int low = 0;
            int median = (top + low) / 2;
            while (median > top || median < low) {
                if (array[median] == array[i]) {
                    break;
                }

                if (array[median] > array[i]) {
                    top = median;
                    median = (low + top) / 2;
                } else {
                    low = median;
                    median = (low + top) / 2;
                }
            }

            for (int k = i; k >= median + 1; k--) {
                double temp = array[k - 1];
                array[k - 1] = array[k];
                array[k] = temp;
            }
        }
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void insertSort(AnyType[] arr) {
        //O(N2)
        for(int i = 1; i < arr.length; i++) {
            AnyType temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

}
