package grammar.nowcoder;

import java.util.Scanner;

public class Java13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        long count = 0;
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value <= 0) break;
            sum += value;
            count++;
        }
        System.out.printf("%.2f", count == 0 ? 0.0 : sum / count);
    }
}
