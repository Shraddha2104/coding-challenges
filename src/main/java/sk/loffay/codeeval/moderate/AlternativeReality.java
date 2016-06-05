package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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
            System.out.println(combinationsStack(number));
        }
    }

    public static int combinations(int number) {
        return count(number, 50);
    }

    private static int count(int number, int lastCoin) {
        if (number == 0) {
            return 1;
        }

        int result = 1;
        int[] coins = {50, 25, 10, 5};
        for (int coin: coins) {
            if (number >= coin && coin <= lastCoin) {
                result += count(number - coin, coin);
            }
        }

        return result;
    }

    public static int combinationsStack(int number) {

        LinkedList<Tuple> stack = new LinkedList<>();
        stack.push(new Tuple(number, 50));
        int[] coins = {50, 25, 10, 5};

        int combinations = 0;
        while (!stack.isEmpty()) {
            Tuple tuple = stack.peek() != null ? stack.pop() : null;
            if (tuple != null) {
                for (int coin: coins) {
                    if (coin <= tuple.number && coin <= tuple.coin) {
                        stack.push(new Tuple(tuple.number - coin, coin));
                        combinations++;
                    }
                }
            }
        }

        return combinations + 1;
    }

    private static class Tuple {
        int number;
        int coin;

        public Tuple(int number, int coin) {
            this.number = number;
            this.coin = coin;
        }
    }
}
