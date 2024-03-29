package grammar.nowcoder;

import java.util.Scanner;

public class Java23 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.nextLine();
            // print就是需要你定义的方法
            print(Class.forName(className).newInstance());
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