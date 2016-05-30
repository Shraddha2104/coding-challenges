package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class MeetCocktailSort {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split("\\|");
            int iterations = Integer.parseInt(split[1].trim());
            String[] strNumbers = split[0].trim().split(" ");
            int[] numbers = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                numbers[i] = Integer.parseInt(strNumbers[i]);
            }

            cocktailSort(numbers, iterations);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(numbers[i]);
            }

            System.out.println(stringBuilder);
        }
    }

    public static void cocktailSort(int[] arr, int iterations) {

        int iteration = 0;

        while (iteration < iterations) {
            int i = iteration;
            for (;i < arr.length - iteration - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }

            for (;i > iteration; i--) {
                if (arr[i] < arr[i-1]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }

            iteration++;
        }
    }
}
