package grammar.nowcoder;

import java.util.Scanner;

public class Java35 {
    public static void main(String[] args) {
        int year = new Scanner(System.in).nextInt();
        for (int month = 1; month <= 12; month++) {
            System.out.println(year + "年" + month + "月：" + java.time.YearMonth.of(year, month).lengthOfMonth() + "天");
        }
    }
}
