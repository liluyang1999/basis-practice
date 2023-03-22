package grammar.nowcoder;

import java.util.Scanner;

public class Java6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float height = scanner.nextFloat();
        float weight = scanner.nextFloat();

        float factor = weight / (height * height);
        String result = factor < 18.5 ? "偏瘦" : factor < 20.9 ? "苗条" :
                        factor < 24.9 ? "适中" : "偏胖";
        System.out.println(result);
    }

}
