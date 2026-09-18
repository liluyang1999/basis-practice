package grammar.nowcoder;

import java.util.Scanner;

public class Java29 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        if (!input.matches("[+-]?[0-9]+")) throw new IllegalArgumentException("integer text required");
        int sign = input.charAt(0) == '+' || input.charAt(0) == '-' ? 1 : 0;
        StringBuilder result = new StringBuilder(input);
        for (int offset = input.length() - 3; offset > sign; offset -= 3) result.insert(offset, ',');
        System.out.println(result);
    }
}
