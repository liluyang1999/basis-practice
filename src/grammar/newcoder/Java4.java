package grammar.newcoder;

import java.util.Scanner;

public class Java4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //write your code here.......
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a+" "+b);
    }

}