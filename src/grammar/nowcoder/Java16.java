package grammar.nowcoder;

import java.util.Scanner;

public class Java16 {

    public static void main(String[] args) {
        int[] arr = new int[6];
        int max, min;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();

        max = arr[0];
        min = arr[0];

        for (int i = 1; i < 6; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println(max + " " + min);
    }

}
