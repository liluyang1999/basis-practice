package grammar.nowcoder;

import java.util.Scanner;

public class Java12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        int times = scanner.nextInt();
        if (!Double.isFinite(height) || height < 0 || times < 0) throw new IllegalArgumentException("nonnegative height and integer count required");
        double remaining = Math.scalb(height, -times);
        // Distance through the nth landing, excluding the following upward bounce.
        double distance = times == 0 ? 0 : height * (3 - Math.scalb(4.0, -times));
        if (!Double.isFinite(distance)) throw new ArithmeticException("distance overflow");
        System.out.printf("%.3f %.3f%n", remaining, distance);
    }
}
