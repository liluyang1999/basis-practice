package grammar.nowcoder;

import java.util.Scanner;

public class Java34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNum = scanner.nextDouble();

        double abs = Math.abs(inputNum);
        double square = Math.sqrt(inputNum);
        double log = Math.log(inputNum);
        double sin = Math.sin(inputNum);

        System.out.println(abs);
        System.out.println(square);
        System.out.println(log);
        System.out.println(sin);
    }

}
