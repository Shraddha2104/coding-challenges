package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class FindAWriter {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(findWriterName(line));
        }
    }

    public static String findWriterName(String line) {
        String[] split = line.split("\\|");
        int[] indexes = indexesToInt(split[1]);

        return findWriterName(split[0], indexes);
    }

    public static String findWriterName(String encoded, int[] indexes) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            stringBuilder.append(encoded.charAt(indexes[i] - 1));
        }

        return stringBuilder.toString();
    }

    public static int[] indexesToInt(String index) {
        String[] split = index.split(" ");
        int[] indexes = new int[split.length - 1];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = Integer.parseInt(split[i+1].trim());
        }

        return indexes;
    }
}
