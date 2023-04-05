package grammar.nowcoder;

import java.util.Scanner;

public class Java29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String inputStr = scanner.nextLine();

        StringBuilder builder = new StringBuilder(inputStr);
        int offset = builder.length();
        int count = 0;

        while (offset >= 0) {
            offset--;
            if (offset >= 0) count++;

            if (count == 3 && offset > 0) {
                builder.insert(offset, ',');
                count = 0;
            }
        }

        System.out.println(builder);
    }

}
