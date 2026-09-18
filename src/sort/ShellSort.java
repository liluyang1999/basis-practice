package sort;

public class ShellSort {
    public static void main(String[] args) {
        SortDemo.run("ShellSort", ShellSort::sort, args);
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int value = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > value) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = value;
            }
        }
    }
}
