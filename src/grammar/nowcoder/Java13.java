package grammar.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            int randomNumber = scanner.nextInt();
            if (randomNumber <= 0) {
                break;
            }

            list.add(randomNumber);
        }

        double sum = 0.0;
        for (Integer each : list) {
            sum += each;
        }
        System.out.printf("%.2f", sum / list.size());
    }

}
