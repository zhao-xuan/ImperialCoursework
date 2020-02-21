package Practicec2b8;

public class Rectangle {

    private final Point topLeft;
    private final int width;
    private final int height;

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int area() {
        return this.getWidth() * this.getHeight();
    }

    public Point getBottomRight() {
        return new Point(this.getTopLeft().getCoordX() + this.getWidth(),
                this.getTopLeft().getCoordY() + this.getHeight());
    }

    public String toString() {
        return "(top-left = " + this.getTopLeft() + ", width = " + this.getWidth() + ", height = "
                + this.getHeight() + ")";
    }
}