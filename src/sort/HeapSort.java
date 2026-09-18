package sort;

public class HeapSort {
    public static void main(String[] args) {
        SortDemo.run("HeapSort", HeapSort::sort, args);
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) siftDown(arr, i, arr.length);
        for (int end = arr.length - 1; end > 0; end--) {
            int value = arr[0]; arr[0] = arr[end]; arr[end] = value;
            siftDown(arr, 0, end);
        }
    }

    private static void siftDown(int[] arr, int parent, int size) {
        int value = arr[parent];
        while (parent < size / 2) {
            int child = 2 * parent + 1;
            if (child + 1 < size && arr[child + 1] > arr[child]) child++;
            if (value >= arr[child]) break;
            arr[parent] = arr[child];
            parent = child;
        }
        arr[parent] = value;
    }
}
