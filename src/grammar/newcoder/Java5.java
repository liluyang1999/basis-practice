package grammar.newcoder;

import java.util.Scanner;

public class Java5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();
        int cost;

        if (price < 100) {
            cost = price;
        } else if (price < 500) {
            cost = (int)(price * 0.9);
        } else if (price < 2000) {
            cost = (int)(price * 0.8);
        } else if (price < 5000) {
            cost = (int)(price * 0.7);
        } else {
            cost = (int)(price * 0.6);
        }
        System.out.println(cost);
    }

}
