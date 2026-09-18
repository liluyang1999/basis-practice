package grammar.nowcoder;

import java.util.Scanner;

public class Java24 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();
            Class<? extends Java24Base> type = switch (className) {
                case "grammar.nowcoder.Java24Base" -> Java24Base.class;
                case "grammar.nowcoder.Java24Sub1" -> Java24Sub1.class;
                case "grammar.nowcoder.Java24Sub2" -> Java24Sub2.class;
                default -> throw new IllegalArgumentException("unknown exercise class: " + className);
            };
            Java24Base obj = type.getDeclaredConstructor().newInstance();
            System.out.println(getClassName(obj));
        }
    }

    public static String getClassName(Java24Base obj) {

        //write your code here......
        return obj.getClass().getSimpleName();

    }

}

class Java24Base {

}

class Java24Sub1 extends Java24Base {

}

class Java24Sub2 extends Java24Base {

}