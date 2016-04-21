package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 52.044
 * mem: 8077312
 */
public class FirstNonRepeatedCharacter {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Character character = firstNonRepeatedCharacter(line.toCharArray());

            System.out.println(character != null ? character : "");
        }
    }

    public static Character firstNonRepeatedCharacter(char[] str) {

        Character character = null;

        Set<Character> repeatedCharacters = new HashSet<>();

        for (int i = 0; i < str.length; i++) {

            if (repeatedCharacters.contains(str[i])) {
                continue;
            }

            boolean found = false;
            for (int j = i + 1; j < str.length; j++) {
                if (str[j] == str[i]) {
                    found = true;
                    repeatedCharacters.add(str[i]);
                    break;
                }
            }

            if (!found && !repeatedCharacters.contains(str[i])) {
                character = str[i];
                break;
            }
        }

        return character;
    }
}
