package grammar.nowcoder;

import java.util.Scanner;

public class Java12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initHeight = scanner.nextDouble();
        double times = scanner.nextDouble();
        scanner.nextLine();

        double distRecord = 0.0;
        double curHeight = initHeight;
        for (int i = 0; i < times; i++) {
            distRecord = distRecord + curHeight * 1.5;
            curHeight = curHeight / 2;
        }
        distRecord = distRecord - curHeight;

        System.out.printf("%.3f %.3f\n", curHeight, distRecord);
    }

}
