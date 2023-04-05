package grammar.nowcoder;

import java.util.Scanner;

public class Java26 {

    public static void main(String[] args) {
        Java26Comparator comparator = new Java26ComparatorImpl();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(comparator.max(x, y));
        }
    }

}

interface Java26Comparator {
    /**
     * 返回两个整数中的最大值
     */
    int max(int x, int y);
}

//write your code here......
class Java26ComparatorImpl implements Java26Comparator {

    @Override
    public int max(int x, int y) {
        return x > y ? x : y;
    }

}

