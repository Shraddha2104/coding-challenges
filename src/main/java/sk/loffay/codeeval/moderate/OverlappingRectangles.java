package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class OverlappingRectangles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            System.out.println(parseAndTestOverlap(line) ? "True" : "False");
        }
    }

    public static boolean parseAndTestOverlap(String line) {
        List<Point> points = parsePoints(line);
        List<Rectangle> rectangles = constructRectangles(points);
        return overlap(rectangles);
    }

    /**
     * @return
     */
    public static boolean overlap(List<Rectangle> rectangles) {
        if (rectangles.size() != 2) {
            throw new IllegalArgumentException("Codeeval contains only two rectangles");
        }

        Rectangle rOne = rectangles.get(0);
        Rectangle rTwo = rectangles.get(1);

        return overlap(rOne, rTwo);
    }

    private static boolean overlap(Rectangle rOne, Rectangle rTwo) {
        //top
        for (int x = rOne.upperLeft.x; x <= rOne.lowerRight.x; x++) {
            if (rTwo.containsPoint(x, rOne.upperLeft.y)) {
                return true;
            }
        }

        //bottom
        for (int x = rOne.upperLeft.x; x <= rOne.lowerRight.x; x++) {
            if (rTwo.containsPoint(x, rOne.lowerRight.y)) {
                return true;
            }
        }

        //left
        for (int y = rOne.lowerRight.y; y <= rOne.upperLeft.y; y++) {
            if (rTwo.containsPoint(rOne.lowerRight.x, y)) {
                return true;
            }
        }

        //right
        for (int y = rOne.lowerRight.y; y <= rOne.upperLeft.y; y++) {
            if (rTwo.containsPoint(rOne.upperLeft.x, y)) {
                return true;
            }
        }

        return false;
    }

    public static boolean inRange(int x1, int x2, int y) {
        if (y >= x1 && y <= x2) {
            return true;
        }

        return false;
    }


    public static List<Rectangle> constructRectangles(List<Point> points) {
        List<Rectangle> rectangles = new LinkedList<>();

        Point upperLeftPoint = null;
        boolean upperLeft = true;
        for (Point point: points) {

            if (upperLeft) {
                upperLeftPoint = point;
                upperLeft = false;
            } else {
                rectangles.add(new Rectangle(upperLeftPoint, point));
                upperLeft = true;
            }
        }

        return rectangles;
    }

    public static List<Point> parsePoints(String line) {
        List<Point> points = new LinkedList<>();

        int x = 0;
        boolean xCoordinate = true;
        for (String number: line.split(",")) {
            int intNumber = Integer.parseInt(number);

            if (!xCoordinate) {
                points.add(new Point(x, intNumber));
                xCoordinate = true;
            } else {
                x = intNumber;
                xCoordinate = false;
            }
        }

        return points;
    }

    public static class Rectangle {
        private Point upperLeft;
        private Point lowerRight;

        public Rectangle(Point upperLeft, Point lowerRight) {
            this.upperLeft = upperLeft;
            this.lowerRight = lowerRight;
        }

        public boolean containsPoint(int x, int y) {
            if (inRange(upperLeft.x, lowerRight.x, x) &&
                    inRange(lowerRight.y, upperLeft.y, y)) {
                return true;
            }

            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Rectangle)) return false;

            Rectangle rectangle = (Rectangle) o;

            if (upperLeft != null ? !upperLeft.equals(rectangle.upperLeft) : rectangle.upperLeft != null) return false;
            return lowerRight != null ? lowerRight.equals(rectangle.lowerRight) : rectangle.lowerRight == null;

        }

        @Override
        public int hashCode() {
            int result = upperLeft != null ? upperLeft.hashCode() : 0;
            result = 31 * result + (lowerRight != null ? lowerRight.hashCode() : 0);
            return result;
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
