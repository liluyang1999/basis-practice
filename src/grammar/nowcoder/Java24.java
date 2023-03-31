package grammar.nowcoder;

import java.util.Scanner;

public class Java24 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();
            Java24Base obj = (Java24Base) Class.forName(className).newInstance();
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