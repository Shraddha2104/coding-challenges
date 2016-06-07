package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class MinimumCoins {
    private static final int[] COINS = new int[]{5, 3, 1};

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int amount = Integer.parseInt(line);

            System.out.println(totalNumberOfCoins(amount));
        }
    }

    public static int totalNumberOfCoins(int amount) {
        int totalNumberOfCoins = 0;
        for (int coin: COINS) {
            totalNumberOfCoins += amount/coin;
            amount = amount%coin;

            if (amount == 0) {
                break;
            }
        }

        return totalNumberOfCoins;
    }
}
