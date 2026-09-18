package grammar.nowcoder;

import java.util.Scanner;

public class Java23 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.nextLine();
            // print就是需要你定义的方法
            Class<?> type = switch (className) {
                case "grammar.nowcoder.Java23First" -> Java23First.class;
                case "grammar.nowcoder.Java23Second" -> Java23Second.class;
                case "grammar.nowcoder.Java23Third" -> Java23Third.class;
                default -> throw new IllegalArgumentException("unknown exercise class: " + className);
            };
            print(type.getDeclaredConstructor().newInstance());
        }
    }

    //write your code here......
    public static void print(Object object) {
        System.out.println(object.toString());
    }

}

class Java23First {
    public String toString() {
        return "First";
    }
}

class Java23Second {
    public String toString() {
        return "Second";
    }
}

class Java23Third {
    public String toString() {
        return "Third";
    }
}