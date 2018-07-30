package ch14examples;

import java.util.LinkedList;

public class PolyLine {
  // Construct a polyline from an array of points
  public PolyLine(Point[] points) {
    // Add the  points
    for(Point point : points) {
      polyline.add(point);
    }
  }
  // Construct a polyline from an array of coordinates
  public PolyLine(double[][] coords) {
    for(double[] xy : coords) {
      addPoint(xy[0], xy[1]);
    }
  }

  // Add a Point object to the list
  public void addPoint(Point point) {
    polyline.add(point);                                               // Add the new point
  }

  // Add a point to the list
  public void addPoint(double x, double y) {
    polyline.add(new Point(x, y));
  }

  // String representation of a polyline
  @Override
  public String toString() {
    StringBuffer str = new StringBuffer("Polyline:");

    for(Point point : polyline) {
      str.append(" "+ point);                                          // Append the current point
    }
    return str.toString();
  }

  private LinkedList<Point> polyline = new LinkedList<>();
}
