package grammar.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Java17 {

    public static void main(String[] args) {
        int[] arr = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        //write your code here......
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            arr[i] = arr[i] ^ arr[length - 1 - i];
            arr[length - 1 - i] = arr[i] ^ arr[length - 1 - i];
            arr[i] = arr[i] ^ arr[length - 1 - i];
        }

        System.out.println(Arrays.toString(arr));
    }

}
