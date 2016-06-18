package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Pavol Loffay
 */
public class SimpleSorting {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            System.out.println(simpleSorting(line));
        }
    }

    public static String simpleSorting(String line) {
        double[] numbers = sortLineNumbers(line);
        return toString(numbers);
    }

    public static double[] sortLineNumbers(String line) {
        String[] split = line.split(" ");
        double[] numbers = new double[split.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(split[i].trim());
        }

        bubbleSort(numbers);

        return numbers;
    }

    private static void bubbleSort(double[] arr) {

        boolean change = true;
        int last = arr.length;
        while (change) {
            change = false;

            for (int i = 1; i < last; i++) {
                if (arr[i-1] > arr[i]) {
                    double temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    change = true;
                }
            }

            last--;
        }
    }

    private static String toString(double[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(String.format("%.3f", arr[i]));
        }

        return stringBuilder.toString();
    }
}
