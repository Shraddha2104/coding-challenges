package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class InterruptedBubbleSort {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            final String[] split = line.split("\\|");

            String[] strNumbers = split[0].trim().split(" ");
            long[] numbers = new long[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                numbers[i] = Long.parseLong(strNumbers[i]);
            }

            long count = Long.parseLong(split[1].trim());
            interruptedBubbleSort(numbers, count);

            StringBuilder stringBuilder = new StringBuilder();
            for (long num: numbers) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(num);
            }
            System.out.println(stringBuilder);
        }
    }

    public static void interruptedBubbleSort(long[] numbers, long count) {

        int iterations = 0;
        while (iterations < count && iterations < numbers.length + 10) {
            for (int i = 0; i < numbers.length-1 - iterations; i++) {
                if (numbers[i+1] < numbers[i]) {
                    long swap = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = swap;
                }
            }

            iterations++;
        }
    }
}
