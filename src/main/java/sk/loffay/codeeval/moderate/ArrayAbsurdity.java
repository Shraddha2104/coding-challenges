package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class ArrayAbsurdity {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(";");
            int size = Integer.parseInt(split[0]);
            String[] numbersStr = split[1].trim().split(",");
            int[] numbers = new int[size];
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numbersStr[i].trim());
                sum += numbers[i];
            }

            int duplicate = sum - (size - 1)*(size - 2)/2;
            System.out.println(duplicate);
        }
    }
}
