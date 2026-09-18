package grammar.nowcoder;

import java.util.Scanner;

public class Java11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getCM(scanner.nextInt(), scanner.nextInt()));
    }

    /** Nonnegative LCM; zero inputs give zero, overflow of the int result is explicit. */
    public static int getCM(int m, int n) {
        long a = Math.abs((long) m), b = Math.abs((long) n);
        if (a == 0 || b == 0) return 0;
        long x = a, y = b;
        while (y != 0) { long remainder = x % y; x = y; y = remainder; }
        return Math.toIntExact(a / x * b);
    }
}
