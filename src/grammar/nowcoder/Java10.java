package grammar.nowcoder;

import java.util.Scanner;

public class Java10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = 0;
        while (true) {
            long number = scanner.nextLong();
            if (number > 0) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

}
