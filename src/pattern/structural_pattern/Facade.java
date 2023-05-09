package pattern.structural_pattern;

public class Facade {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawSquare();
        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
    }

}

class ShapeMaker {

    public Rectangle rectangle;

    public Circle circle;

    public Square square;

    public ShapeMaker() {
        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawSquare() {
        this.square.draw();
    }

}

interface GeneralShape {
    void draw();
}

class Rectangle implements GeneralShape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }

}

class Circle implements GeneralShape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }

}

class Square implements GeneralShape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }

}


