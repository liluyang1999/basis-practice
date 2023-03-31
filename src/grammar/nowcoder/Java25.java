package grammar.nowcoder;

import java.util.*;

public class Java25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            Java25Base base = new Java25Sub();
            int result = base.calculate(a, b);
            System.out.println(result);
        }

    }

}

abstract class Java25Base {

    public int calculate(int a, int b) {
        int sum = sum(a, b);
        int avg = avg(a, b);
        if (avg == 0) {
            return 0;
        } else {
            return sum / avg;
        }
    }

    public abstract int sum(int a, int b);

    public abstract int avg(int a, int b);

}

class Java25Sub extends Java25Base {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int avg(int a, int b) {
        return (a + b) / 2;
    }

}