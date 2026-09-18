package sort;

public class SelectionSort {
    public static void main(String[] args) {
        SortDemo.run("SelectionSort", SelectionSort::sort, args);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int choice = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[choice]) choice = j;
            }
            int value = arr[i];
            arr[i] = arr[choice];
            arr[choice] = value;
        }
    }
}
