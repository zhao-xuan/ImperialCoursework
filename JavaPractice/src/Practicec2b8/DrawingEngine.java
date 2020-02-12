package Practicec2b8;

import java.util.HashSet;
import java.util.Set;

public class DrawingEngine {

  private Set<Rectangle> rectangles;

  public DrawingEngine() {
    rectangles = new HashSet<Rectangle>();
  }

  public void addRectangle(Rectangle rectangle) {
    rectangles.add(rectangle);
  }

  public boolean contains(Rectangle r1, Rectangle r2) {
    return
        r1.getTopLeft().getCoordX() <= r2.getTopLeft().getCoordX()
            && r1.getTopLeft().getCoordY() <= r2.getTopLeft().getCoordY()
            && r1.getBottomRight().getCoordX() >= r2.getBottomRight().getCoordX()
            && r1.getBottomRight().getCoordY() >= r2.getBottomRight().getCoordY();
  }

  public int maxArea() {
    int result = 0;
    for (Rectangle r : rectangles) {
      if (r.area() > result) {
        result = r.area();
      }
    }
    return result;
  }

  public String toString() {

    String result = "Drawing engine is looking after these rectangles:";
    for (Rectangle r : rectangles) {
      result += "\n   " + r.toString();
    }
    return result;

  }
}