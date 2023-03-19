package others;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 7, 9, 8, 3, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
        int[] array1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort1(array);
        System.out.println(Arrays.toString(array));
    }


    //交换法
    public static void sort(int[] arr) {
        for(int gap = arr.length/2; gap >= 1; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                //依次向前进行交换
                while(j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j , j - gap);
                    j -= gap;
                }
            }
        }
    }


    //自行思考
    public static void sort1(int[] arr) {
        for(int gap = arr.length/2; gap >= 1; gap /= 2) {
            for(int index = 0; index < gap; index++) {
                for (int i = index + gap; i <= arr.length-1; i += gap) {
                    //比前面小才开始往前找插入位置，否则跳过，不需要找了
                    if(arr[i] < arr[i-gap]) {
                        for (int j = i; j >= 0; j -= gap) {
                            if (arr[j] > arr[i]) {
                                int temp = arr[j];
                                arr[j] = arr[i];
                                arr[i] = temp;
                            }
                        }
                    }
                }
            }
        }
    }


    //插入时采用移动法
    public static void sort2(int[] arr) {
        for(int gap = arr.length/2; gap >=1; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]) {
                    while(j - gap >= 0 && temp < arr[j-gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void swap(int[] arr, int x1, int x2) {
        int temp = arr[x1];
        arr[x1] = arr[x2];
        arr[x2] = temp;
        Integer int1 = Integer.valueOf(3);
        System.out.println(int1.getClass());
    }

}
