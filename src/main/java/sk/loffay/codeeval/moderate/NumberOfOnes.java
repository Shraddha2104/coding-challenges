package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 * 100%
 */
public class NumberOfOnes {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int number = Integer.parseInt(line);
            System.out.println(numberOfOnes(number));
        }
    }

    public static int numberOfOnes(int number) {

        int numberOfOnes = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                numberOfOnes++;
            }

            number = number >> 1;
        }

        return numberOfOnes;
    }
}
