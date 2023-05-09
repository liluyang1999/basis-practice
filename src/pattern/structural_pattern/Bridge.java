package pattern.structural_pattern;

public class Bridge {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new CircleShape(10, 20, 30, new DrawingApi1());
        shapes[1] = new CircleShape(50, 70, 110, new DrawingApi2());
        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }

}

interface DrawingApi {

    void drawCircle(double x, double y, double radius);

}

class DrawingApi1 implements DrawingApi {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %.2f:%.2f radius %.2f\n", x, y, radius);
    }

}

class DrawingApi2 implements DrawingApi {

    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2.circle at %.2f:%.2f radius %.2f\n", x, y, radius);
    }

}

interface Shape {

    void draw();

    void resizeByPercentage(double percentage);

}

class CircleShape implements Shape {

    private double x, y, radius;

    private DrawingApi drawingApi;

    public CircleShape(double x, double y, double radius, DrawingApi drawingApi) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawingApi = drawingApi;
    }

    @Override
    public void draw() {
        drawingApi.drawCircle(x, y, radius);
    }

    @Override
    public void resizeByPercentage(double percentage) {
        radius = radius * percentage;
    }

}




