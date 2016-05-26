package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 */
public class FatFinger {

    public static char[][] QWERTY = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    /**
     * Method takes as input wrong spelled word and returns corrected version from Dictionary. The word is wrong
     * spelled because user has fat finger and hit the wrong letters on his QWERTY mobile keyboard. This is like
     * auto-correction functionality.
     *
     * Assume that words in dictionary are ordered from the most used ones.
     *
     * Optimization:
     *   QUERTY could be stored as Map<Character, Set<Character>> where the set contains surroundings characters
     *   Dictionary could be stored in map with key word length and value would be list of words (ordered by most used)
     *
     * @param wordFromKeyboard - wrong spelled word
     * @return word - correctly spelled word
     */
    public static String word(String wordFromKeyboard) {

        // check if there is the exact word
        for (String word: Dictionary.WORDS) {
            if (word.equals(wordFromKeyboard)) {
                return wordFromKeyboard;
            }
        }

        for (String original: Dictionary.WORDS) {
            if (original.length() == wordFromKeyboard.length() && canBeChangedTo(wordFromKeyboard, original)) {
                return original;
            }
        }

        return wordFromKeyboard;
    }

    private static boolean canBeChangedTo(String given, String original) {
        for (int i = 0; i < given.length(); i++) {
            char g = given.charAt(i);
            char o = original.charAt(i);

            if (g != o && !canBeChangedTo(g, o)) {
                return false;
            }
        }

        return true;
    }

    private static boolean canBeChangedTo(char given, char original) {

        if (original == given) {
            return true;
        }

        for (int i = 0; i < QWERTY.length; i++) {
            for (int j = 0; j < QWERTY[i].length; j++) {

                if (given == QWERTY[i][j]) {
                    // up
                    if (i > 0 && QWERTY[i-1][j] == original) {
                        return true;
                    }
                    // down
                    if (i + 1 > QWERTY.length && j < QWERTY[i+1].length && QWERTY[i+1][j] == original) {
                        return true;
                    }
                    // left
                    if (j > 0 && QWERTY[i][j-1] == original) {
                        return true;
                    }
                    // right
                    if (j + 1 < QWERTY[i].length && QWERTY[i][j+1] == original) {
                        return true;
                    }

                    return false;
                }
            }
        }

        return false;
    }
}
