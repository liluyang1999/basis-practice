package sort;

public class QuickSort {
    public static void main(String[] args) {
        SortDemo.run("QuickSort", QuickSort::sort, args);
    }

    public static void sort(int[] arr) { sort(arr, 0, arr.length - 1); }

    private static void sort(int[] arr, int low, int high) {
        while (low < high) {
            int pivot = arr[low + (high - low) / 2];
            int less = low, cursor = low, greater = high;
            while (cursor <= greater) {
                if (arr[cursor] < pivot) swap(arr, less++, cursor++);
                else if (arr[cursor] > pivot) swap(arr, cursor, greater--);
                else cursor++;
            }
            // Recurse into the smaller side only: at most O(log n) stack frames.
            if (less - low < high - greater) {
                sort(arr, low, less - 1);
                low = greater + 1;
            } else {
                sort(arr, greater + 1, high);
                high = less - 1;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int value = arr[a]; arr[a] = arr[b]; arr[b] = value;
    }
}
