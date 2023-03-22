package grammar.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Java7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, String> map = new HashMap<>() {
            {
                this.put('A', "优秀");
                this.put('B', "良好");
                this.put('C', "及格");
                this.put('D', "不及格");
            }
        };

        String inputLevel = scanner.nextLine();
        char ch = inputLevel.charAt(0);
        String result = map.get(ch);
        System.out.println(Objects.requireNonNullElse(result, "未知错误"));
    }

}
