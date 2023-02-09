import java.io.IOException;
import java.util.Scanner;

public class Java49 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        method(start, end);
    }

    public static void method(int start, int end) {
        int count = 0;
        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }
        for (int i = start; i <= end; i++) {
            if (i <= 2) {
                continue;
            }
            if (isPrimeNumber(i)) {
                count++;
            }
        }
        System.out.println(start+"到"+end+"之间有"+count+"个大于2的素数");
    }

    public static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

