package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class CalculateDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            System.out.println(distance(line));
        }
    }

    public static int distance(String line) {
        int[] numbers = parseLine(line);

        int x1 = numbers[0];
        int y1 = numbers[1];

        int x2 = numbers[2];
        int y2 = numbers[3];


        return (int)Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

    }

    public static int[] parseLine(String line) {
        line = line.replace("(", "");
        line = line.replace(")", "");
        line = line.replace(",", "");
//        line = line.replace(" ", "");

        String[] split = line.split(" ");
        int[] numbers = new int[split.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        return numbers;
    }
}
