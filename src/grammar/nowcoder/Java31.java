package grammar.nowcoder;

import java.util.Scanner;

public class Java31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder binary = new StringBuilder();
        calBinary(num, binary);
        System.out.println(binary);
    }

    public static void calBinary(int num, StringBuilder builder) {
        int each = num % 2;
        num = num / 2;
        builder.insert(0, each);

        if (num > 0) {
            calBinary(num, builder);
        }
    }

}
