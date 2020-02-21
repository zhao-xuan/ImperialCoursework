class Point {
    protected final double x;
    protected final double y;
    protected final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistance(Point p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2) + Math.pow(p.getZ() - z, 2));
    }

    public Point getOrigin() {
        return new Point(0.0, 0.0, 0.0);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}

class Color {
    private double r;
    private double g;
    private double b;

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

	@Override
	public String toString() {
		return "[b=" + b + ", g=" + g + ", r=" + r + "]";
	}
}

class ColoredPoint extends Point {
    Color color;

    public ColoredPoint(double x, double y, double z, Color color) {
        super(x, y, z);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", color=" + color;
    }
}

public class Practice0f05 {
    public static void main(String[] args) {
        Color color1 = new Color(65, 172, 89);
        Color color2 = new Color(87, 254, 19);
        Color color3 = new Color(77, 14, 125);
        ColoredPoint cp1 = new ColoredPoint(12, 5, 7, color1);
        ColoredPoint cp2 = new ColoredPoint(3, 3, 7, color2);
        ColoredPoint cp3 = new ColoredPoint(7, 5, 4, color3);
        System.out.println(cp1);
        System.out.println(cp2);
        System.out.println(cp3);
    }
}