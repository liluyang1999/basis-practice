package grammar.nowcoder;

import java.util.Scanner;

public class Java38 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        java.util.Set<Integer> seen = new java.util.LinkedHashSet<>();
        input.codePoints().forEach(seen::add);
        StringBuilder result = new StringBuilder();
        seen.forEach(result::appendCodePoint);
        System.out.println(result);
    }
}
