package grammar.nowcoder;

import java.util.Random;
import java.util.Scanner;

public class Java33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed = scanner.nextInt();
        Random random = new Random(seed);
        System.out.println(random.nextInt(1, 7));
    }

}
