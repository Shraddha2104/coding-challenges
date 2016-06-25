package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class PointInCircle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            System.out.println(pointInCircle(line));
        }
    }

    public static boolean pointInCircle(String line) {
        double[] numbers = parseLine(line);

        double centerX = numbers[0];
        double centerY = numbers[1];
        double radius = numbers[2];
        double x = numbers[3];
        double y = numbers[4];

        double distanceFromCenter = Math.sqrt(Math.pow(x-centerX, 2) + Math.pow(y-centerY, 2));

        return distanceFromCenter < radius;
    }

    public static double[] parseLine(String line) {
        line = line.replace("Center: ", "");
        line = line.replace("; Radius:", "");
        line = line.replace("; Point:", "");
        line = line.replace("(", "");
        line = line.replace(")", "");
        line = line.replace(",", "");

        String[] split = line.split(" ");
        double[] numbers = new double[split.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(split[i]);
        }

        return numbers;
    }
}
