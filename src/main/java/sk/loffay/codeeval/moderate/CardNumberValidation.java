package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class CardNumberValidation {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            line = line.replace(" ", "");
            int[] numbers = new int[line.length()];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(""+ line.charAt(i));
            }

            System.out.println(creditCardIsValid(numbers) ? 1 : 0);
        }
    }

    public static boolean creditCardIsValid(int[] numbers) {

        boolean even = false;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (even) {
                int doubled = 2*numbers[i];
                numbers[i] = doubled > 9 ? sumOfDigits(doubled) : doubled;
                even = false;
            } else {
                even = true;
            }
        }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum%10 == 0;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }

        return sum;
    }
}
