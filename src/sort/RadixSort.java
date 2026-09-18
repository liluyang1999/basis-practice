package sort;

public class RadixSort {
    public static void main(String[] args) {
        SortDemo.run("RadixSort", RadixSort::sort, args);
    }

    public static void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        // Flip the sign bit so unsigned byte order agrees with signed int order.
        for (int shift = 0; shift < Integer.SIZE; shift += Byte.SIZE) {
            int[] counts = new int[256];
            for (int value : arr) counts[((value ^ Integer.MIN_VALUE) >>> shift) & 255]++;
            for (int i = 1; i < counts.length; i++) counts[i] += counts[i - 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = ((arr[i] ^ Integer.MIN_VALUE) >>> shift) & 255;
                buffer[--counts[digit]] = arr[i];
            }
            System.arraycopy(buffer, 0, arr, 0, arr.length);
        }
    }
}
