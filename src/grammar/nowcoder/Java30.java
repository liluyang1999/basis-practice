package grammar.nowcoder;

import java.util.Scanner;

public class Java30 {

    public static void main(String[] args) {
        String string = "H e l l o ! n o w c o d e r";
        Scanner scanner= new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        System.out.println(check(string, word));
    }

    public static int check(String str, String word) {
        //write your code here......
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == word.charAt(0)) {
                count++;
            }
        }
        return count;
    }

}
