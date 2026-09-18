package sort;


public class InsertionSort {

    public static void main(String[] args) {
        SortDemo.run("InsertionSort", InsertionSort::sort, args);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j >= 1 && (temp < arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
