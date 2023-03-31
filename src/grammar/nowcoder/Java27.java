package grammar.nowcoder;

import java.util.Scanner;

public class Java27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Java27Sub sub = new Java27Sub(x, y);
            System.out.println(sub.sum());
        }
    }

}

class Java27Base {

    private int x;
    private int y;

    public Java27Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int sum() {
        return getX() + getY();
    }

}

class Java27Sub extends Java27Base {

    public Java27Sub(int x, int y) {
        super(x, y);
    }

    //write your code here......
    @Override
    public int getX() {
        return super.getX() * 10;
    }

}
