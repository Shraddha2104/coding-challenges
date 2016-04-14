package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 27.895
 */
public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] params = line.split(" ");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            int n = Integer.parseInt(params[2]);

            System.out.print(fizzBuzz(x, y, n));
        }
    }

    public static String fizzBuzz(int x, int y, int n) {
        if (x < 1 || x > 20 ||
                y < 1 || y > 20 ||
                n < 21 || n > 100) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            boolean empty = true;

            if (i%x == 0) {
                stringBuilder.append("F");
                empty = false;
            }

            if (i%y == 0) {
                stringBuilder.append("B");
                empty = false;
            }

            if (empty) {
                stringBuilder.append(Integer.toString(i));
            }

            stringBuilder.append(" ");
        }

        return stringBuilder.append("\n").toString();
    }
}
