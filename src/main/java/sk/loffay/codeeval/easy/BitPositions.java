package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import sk.loffay.Tags;

/**
 * @author Pavol Loffay
 */
public class BitPositions {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(",");

            int number = Integer.parseInt(split[0]);
            int pos1 = Integer.parseInt(split[1]);
            int pos2 = Integer.parseInt(split[2]);

            System.out.println(hasTheSameBitAtPositions(number, pos1, pos2));
        }
    }

    @Tags("bits")
    public static boolean hasTheSameBitAtPositions(int number, int pos1, int pos2) {

        int pos1Num = (number >> (pos1 - 1)) & 1;
        int pos2Num = (number >> (pos2 - 1)) & 1;

        return (pos1Num^pos2Num) == 0;
    }
}
