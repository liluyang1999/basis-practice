package sort;


public class BubbleSort {

    public static void main(String[] args) {
        SortDemo.run("BubbleSort", BubbleSort::sort, args);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = 0; j <= arr.length - 2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
