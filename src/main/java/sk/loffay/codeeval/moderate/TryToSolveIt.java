package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class TryToSolveIt {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            System.out.println(decode(line));
        }
    }

    public static String decode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: str.toCharArray()) {
            stringBuilder.append(decodeChar(ch));
        }

        return stringBuilder.toString();
    }

    public static char decodeChar(char ch) {
        char[][] decode = new char[][] {
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'},
                {'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't'}
        };

        for (int i = 0; i < decode.length; i++) {
            for (int j = 0; j < decode[i].length; j++) {
                if (ch == decode[i][j]) {
                    int rowIndex = i == 0 ? 1 : 0;
                    return decode[rowIndex][j];
                }
            }
        }

        return 'a';
    }
}
