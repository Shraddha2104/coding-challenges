package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class CleanUpTheWords {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            System.out.println(cleanSentence(line));
        }
    }

    public static String cleanSentence(String sentence) {
        sentence = sentence.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();
        boolean inSpace = false;

        for (int i = 0; i < sentence.length(); i++) {
            if ((int)sentence.charAt(i) >= 97 && (int)sentence.charAt(i) <= 122) {
                stringBuilder.append(sentence.charAt(i));
                inSpace = false;
            } else if (inSpace){
                continue;
            } else {
                stringBuilder.append(" ");
                inSpace = true;
            }
        }

        return stringBuilder.toString();
    }
}
