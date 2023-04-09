package grammar.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java43 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String name = scanner.next();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Amy");
        map.put(2, "Joe");
        map.put(3, "Tom");
        map.put(4, "Susan");

        //write your code here......
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        map.put(5, name);
        map.remove(4);
        map.put(3, "Tommy");

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

}
