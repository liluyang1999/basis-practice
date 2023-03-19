package others;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    }


    //堆排序
    public static <T> void sort(int[] arr) {
        //Build the Max Heap
        for(int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //Start to adjust the structure of the heap, swap end element and top element
        for(int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }


    //Based on the fact that the max heap have been built
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp  = arr[i];
        //begin from the left son
        for(int k = i * 2 + 1; k < arr.length; k = k + 2) {
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;  //The last element in the heap at this moment
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static final long CUTOFF = 1L;
    private static <AnyType extends Comparable<? super AnyType>>
    void quickSort(AnyType[] a, int left, int right) {
        if(left + CUTOFF <= right) {
            AnyType pivot = median(a, left, right);
            int i = left, j = right - 1;
            for(; ;) {
                while(a[++i].compareTo(pivot) < 0) {}  //stop while the elem is bigger than pivot
                while(a[--j].compareTo(pivot) > 0) {}  //stop while the elem is smaller than pivot
                if(i < j) {   //the equalling is impossible because the pivot has between the left and right
                    swapReference(a, i, j);
                } else {
                    break;
                }
            }
            swapReference(a, i, right - 1);  //choose to swap between i and right
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        } else {
            InsertSort.insertSort(a);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void swapReference(AnyType[] a, int x1, int x2) {

    }

    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median(AnyType[] a, int left, int right) {

        return null;
    }


}
