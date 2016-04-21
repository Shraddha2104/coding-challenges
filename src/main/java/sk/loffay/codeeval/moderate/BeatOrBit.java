package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 51.773
 * mem: 8220672
 */
public class BeatOrBit {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Params params = parseLine(line);

            StringBuilder stringBuilder = new StringBuilder();
            for (int grey: params.grey) {
                long grayToBinary = grayToBinary(grey);

                stringBuilder.append(grayToBinary).append(" | ");
            }

            System.out.println(stringBuilder.delete(stringBuilder.length() - 2,
                    stringBuilder.length()).toString().trim());
        }
    }

    private static Params parseLine(String line) {
        String[] split = line.split("\\|");
        int[] greys = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            greys[i] = Integer.parseInt(split[i].trim(), 2);
        }

        return new Params(greys);
    }

    private static class Params {
        int[] grey;

        public Params(int[] grey) {
            this.grey = grey;
        }
    }

    public static long grayToBinary(long num) {
        long mask;
        for (mask = num >> 1; mask != 0; mask = mask >> 1) {
            num = num ^ mask;
        }
        return num;
    }
}
