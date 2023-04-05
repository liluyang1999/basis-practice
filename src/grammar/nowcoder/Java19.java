package grammar.nowcoder;

import java.util.Scanner;

public class Java19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Java19Data data = new Java19Data(x, y);
            System.out.println(data.getX() + data.getY());
        }
    }

}

class Java19Data {

    private int x;
    private int y;

    public Java19Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}