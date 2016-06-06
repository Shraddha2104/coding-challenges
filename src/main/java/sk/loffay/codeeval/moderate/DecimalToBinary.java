package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class DecimalToBinary {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            System.out.println(intToBinary(Integer.parseInt(line)));
        }
    }

    public static String intToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        String result = "";

        while (number > 0) {
            result = ((number & 1) == 1 ? "1" : "0") + result;

            number = number >> 1;
        }

        return result;
    }
}
