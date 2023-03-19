package grammar.newcoder;

import java.util.Scanner;

public class Java1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        System.out.println(Java1.typeConversion(d));
    }
    public static int typeConversion(double d){

        //write your code here......
        return (int)d;

    }
}
