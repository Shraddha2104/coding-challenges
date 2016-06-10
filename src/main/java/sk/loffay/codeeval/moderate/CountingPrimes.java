package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class CountingPrimes {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(",");
            int from = Integer.parseInt(split[0].trim());
            int to = Integer.parseInt(split[1].trim());

            System.out.println(countOfPrimes(from, to));
        }
    }

    public static int countOfPrimes(int fromInclusive, int toInclusive) {

        int count = 0;
        fromInclusive = fromInclusive <= 1 ? 2 : fromInclusive;
        for (int number = fromInclusive; number > 1 && number <= toInclusive; number++) {

            int numberOfDivisors = 0;
            for (int i = 2; i <= number; i++) {
                if (number%i == 0) {
                    numberOfDivisors++;
                }

                if (numberOfDivisors > 1) {
                    break;
                }
            }

            if (numberOfDivisors <= 1) {
                count++;
            }
        }

        return count;
    }
}
