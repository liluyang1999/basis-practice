package grammar.nowcoder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Java42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Character, Integer> map = new LinkedHashMap<>();

        //write your code here......
        line = line.replaceAll("[^a-zA-Z]", "");
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            Integer counts = map.get(ch);
            if (counts != null) {
                counts += 1;
                map.put(ch, counts);
            } else {
                map.put(ch, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrys = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrys) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
