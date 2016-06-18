package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import sk.loffay.Tags;

/**
 * @author Pavol Loffay
 */
@Tags("string")
public class BeautifulStrings {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(beautyRank(line));
        }
    }

    public static int beautyRank(String line) {
        line = line.toLowerCase();

        Map<Character, Integer> characterMap = new HashMap<>();

        for (Character ch: line.toCharArray()) {
            if ((int)ch >= 97 && (int)ch <= 122) {
                Integer count = characterMap.get(ch);
                count = count == null ? 1 : count + 1;
                characterMap.put(ch, count);
            }
        }

        Integer[] counts = characterMap.values().toArray(new Integer[0]);
        Arrays.sort(counts);

        int result = 0;
        int multiplier = 26;
        for (int i = counts.length - 1; i >= 0; i--) {
            result += counts[i] * multiplier;
            multiplier--;
        }

        return result;
    }
}
