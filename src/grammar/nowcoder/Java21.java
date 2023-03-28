package grammar.nowcoder;

import java.util.Scanner;

public class Java21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            Java21Sub sub = new Java21Sub(x, y, z);
            System.out.println(sub.calculate());
        }
    }

}

class Java21Base {

    private int x;
    private int y;

    public Java21Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class Java21Sub extends Java21Base {

    private int z;

    public Java21Sub(int x, int y, int z) {

        //write your code here
        super(x, y);
        this.z = z;

    }

    public int getZ() {
        return z;
    }

    public int calculate() {
        return super.getX() * super.getY() * this.getZ();
    }

}

