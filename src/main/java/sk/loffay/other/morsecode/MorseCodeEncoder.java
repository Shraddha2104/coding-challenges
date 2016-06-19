package sk.loffay.other.morsecode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public class MorseCodeEncoder {

    private static final char[] ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    private static final String[] MORSE_CODES = {
            ".-",  "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };

    private static final Map<Character, String> CHAR_TO_CODE_MAP = initMorseCodeMap();

    private MorseCodeEncoder() {
    }

    /**
     * Converts text to morse code.
     * If delimiter is null words are not separated by any character/string
     */
    public static String textToMorseCode(String string) {
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                String morseCode = charToMorseCode(string.charAt(i));
                encodedString.append(morseCode);

            }
        }

        return encodedString.toString();
    }

    private static String charToMorseCode(char ch) {
        ch = Character.toLowerCase(ch);

        String morseCode = CHAR_TO_CODE_MAP.get(ch);
        if (morseCode == null) {
            throw new IllegalArgumentException("not valid character [a-zA-Z0-9] = " + ch);
        }

        return morseCode;
    }

    /**
     * init morse code map
     */
    private static Map<Character, String> initMorseCodeMap() {
        if (ALPHABET.length != MORSE_CODES.length) {
            throw new IllegalStateException();
        }

        Map<Character, String> modifiableMorseCode = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            modifiableMorseCode.put(ALPHABET[i], MORSE_CODES[i]);
        }

        return Collections.unmodifiableMap(modifiableMorseCode);
    }
}
