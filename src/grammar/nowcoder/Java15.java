package grammar.nowcoder;

import java.util.Scanner;

public class Java15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Math.abs((long) scanner.nextInt());
        int count = 0;
        do { count++; number /= 10; } while (number > 0);
        System.out.println(count);
    }
}
