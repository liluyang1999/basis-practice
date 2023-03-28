package grammar.nowcoder;

import java.util.Scanner;

public class Java15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;

        while (number > 0) {
            count++;
            number = number / 10;
        }

        System.out.println(count);
    }

}
