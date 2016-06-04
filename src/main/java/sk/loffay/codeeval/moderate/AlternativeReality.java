package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class AlternativeReality {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            Integer number = Integer.parseInt(line);
            System.out.println(combinations(number));
        }
    }

    public static int combinations(int number) {
        return count(number, 50);
    }

    private static int count(int number, int lastCoin) {
        if (number == 0) {
            return 1;
        }

        int result = 0;
        int[] coins = {50, 25, 10, 5, 1};
        for (int coin: coins) {
            if (number >= coin && coin <= lastCoin) {
                result += count(number - coin, coin);
            }
        }

        return result;
    }
}
