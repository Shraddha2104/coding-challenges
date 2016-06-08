package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Pavol Loffay
 */
public class FindASquare {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(", ");
            Point[] points = parsePoints(line);
            System.out.println(isSquare(points));
        }
    }

    public static boolean isSquare(Point[] points) {
        Set<Double> distances = new HashSet<>(points.length * (points.length - 1));
        for (Point point: points) {
            Set<Double> distancesSet = new HashSet<>();
            for (Point innerPoint: points) {
                if (!point.equals(innerPoint)) {
                    Double distance = distance(point, innerPoint);
                    distancesSet.add(distance);
                }
            }

            if (distancesSet.size() != 2) {
                return false;
            }

            distances.addAll(distancesSet);
        }

        return distances.size() == 2;
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    private static class Point {
        public final int x;
        public final int y;

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

    public   static Point[] parsePoints(String line) {
        String[] split = line.split(", ");
        Point[] points = new Point[split.length];

        for (int i = 0; i < split.length; i++) {
            String removedBrackets = split[i].replaceAll("\\)", "");
            removedBrackets = removedBrackets.replaceAll("\\(", "");
            String[] coordinates = removedBrackets.split(",");

            points[i] = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }

        return points;
    }
}
