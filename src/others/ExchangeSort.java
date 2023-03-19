package others;

import java.util.Arrays;

public class ExchangeSort {

    public static void main(String[] args) {
        double[] array = {2.0, 3.0, 1.2, 3.4, 2.3, 8.7, 3.4, 5.6, 3.4, 4.6};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(double[] array, int low, int top) {
        if (low < top) {
            int i = low;
            int j = top;
            double radix = array[low];
            while (i < j) {
                while (i < j && array[j] > radix) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }

                while(i < j && array[i] < radix) {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = radix;
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, top);
        }
    }

}
