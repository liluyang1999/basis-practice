package grammar.nowcoder;

import java.util.Scanner;

public class Java22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Java22Sub sub = new Java22Sub(x, y);
            sub.calculate();
        }
    }

}

class Java22Base {

    private int x;
    private int y;

    public Java22Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void calculate() {
        System.out.println(getX() * getY());
    }

}

class Java22Sub extends Java22Base {

    public Java22Sub(int x, int y) {
        super(x, y);
    }

    //write your code here......
    @Override
    public void calculate() {
        if (getY() == 0) {
            System.out.println("Error");
        } else {
            System.out.println(getX() / getY());
        }
    }

}
