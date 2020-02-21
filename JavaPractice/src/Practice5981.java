abstract class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public boolean isSquare() {
        return this.width == this.height;
    }
}

class Ellipse extends Shape {
    public Ellipse(double width, double height) {
        super(width, height);
    }

    public boolean isCircle() {
        return this.width == this.height;
    }
}