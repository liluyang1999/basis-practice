package grammar.nowcoder;

import java.util.Scanner;

public class Java50 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double s = scanner.nextDouble();
            // Circle和Square是需要你定义的类
            System.out.printf("%.3f%n", new Java50Circle(s).getArea());
            System.out.printf("%.3f%n", new Java50Square(s).getArea());
        }
    }

}

class Java50Shape {

    private double perimeter; // 周长

    public Java50Shape(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

}

interface Java50Area {
    double getArea();
}

// 圆形
class Java50Circle extends Java50Shape implements Java50Area {

    public Java50Circle(double perimeter) {
        super(perimeter);
    }

    //write your code here......
    @Override
    public double getArea() {
        double radius = this.getPerimeter() / Math.PI / 2;
        return Math.PI * Math.pow(radius, 2);
    }

}

// 方形
class Java50Square extends Java50Shape implements Java50Area {

    public Java50Square(double perimeter) {
        super(perimeter);
    }

    //write your code here......
    @Override
    public double getArea() {
        return Math.pow(this.getPerimeter() / 4, 2);
    }

}

