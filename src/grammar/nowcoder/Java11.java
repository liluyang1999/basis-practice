package grammar.nowcoder;

import java.util.Scanner;

public class Java11 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int m = console.nextInt();
        int n = console.nextInt();
        int result = getCM(m, n);
        System.out.println(result);
    }

    public static int getCM(int m, int n){

        //write your code here......
        int cm = Math.max(m, n);
        while (true) {
            if (cm % m == 0 && cm % n == 0) {
                break;
            } else {
                cm++;
            }
        }
        return cm;
    }
}
