package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class MultiplesOfNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");

            int desired = Integer.parseInt(split[0]);
            int num = Integer.parseInt(split[1]);

            System.out.println(multiples(desired, num));
        }
    }

    public static int multiples(int desired, int num) {

        int result = num;

        while (result < desired) {
            result += num;
        }

        return result;
    }
}
