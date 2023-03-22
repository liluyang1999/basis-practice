package grammar.newcoder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputMail = scanner.nextLine();
        String emailMatcher="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";

        //write your code here......
        Pattern pattern = Pattern.compile(emailMatcher);
        Matcher matcher = pattern.matcher(inputMail);
        String result = matcher.matches() ? "邮箱格式合法" : "邮箱格式不合法";
        System.out.println(result);
    }

}
