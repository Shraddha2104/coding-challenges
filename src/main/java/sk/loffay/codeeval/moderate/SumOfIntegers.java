package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 50.939
 * mem: 8691712
 */
public class SumOfIntegers {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int[] parts = parseLine(line);
            int result = largestContinuousSum(parts);

            System.out.println(result);
        }
    }

    public static int largestContinuousSum(int[] arr) {

        int max = arr[0];

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int sum = sum(arr, start, end);
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int[] parseLine(String line) {
        String[] parts = line.split(",");

        int[] result = new int[parts.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }

        return result;
    }
}
