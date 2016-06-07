package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class ColumnNames {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int column = Integer.parseInt(line);
            System.out.println(toExcel(column));
        }
    }

    public static String toExcel(int number) {
        String result = "";

        while (number > 0) {
            number -= 1;
            result  = "" + Character.toChars((65 + (number % 26)))[0] + result;
            number  = number/26;
        }

        return result;
    }
}
