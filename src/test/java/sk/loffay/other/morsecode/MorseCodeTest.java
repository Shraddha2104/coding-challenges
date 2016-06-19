package sk.loffay.other.morsecode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class MorseCodeTest {

    @Test
    public void test() {
        Assert.assertEquals(".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..",
                MorseCodeEncoder.textToMorseCode("abcdefghijklmnopqrstuvwxyz"));
        Assert.assertEquals("", MorseCodeEncoder.textToMorseCode(""));
        Assert.assertEquals(".-", MorseCodeEncoder.textToMorseCode("a"));
        Assert.assertEquals(".-", MorseCodeEncoder.textToMorseCode("et"));
        Assert.assertEquals(".--", MorseCodeEncoder.textToMorseCode("at"));
    }

    @Test
    public void testMorseTreeCreation() {
        MorseCodeTreeDecoder morseCodeTreeDecoder = new MorseCodeTreeDecoder();
        morseCodeTreeDecoder.initWithEnglishDictionary();

        Set<String> words = morseCodeTreeDecoder.toLongestWord(".-");
        Assert.assertEquals(2, words.size());

        String original = "thing";
        String morseCodeStr = MorseCodeEncoder.textToMorseCode(original);
        words = morseCodeTreeDecoder.morseCodeToTextConcatenated(morseCodeStr);
        Assert.assertTrue(words.size() > 0);

        List<List<Set<String>>> phrasesNotConcatenated = morseCodeTreeDecoder.morseCodeToText(morseCodeStr);
        Set<String> phrasesConcatenated = morseCodeTreeDecoder.morseCodeToTextConcatenated(morseCodeStr);

        assertCorrectResult(phrasesNotConcatenated, morseCodeStr);
        Set<String> foundTexts = constructPhrases(phrasesNotConcatenated);
        Assert.assertTrue(foundTexts.contains(original));

        Assert.assertTrue(produceWordTheSameMorseCode(foundTexts, morseCodeStr));
        Assert.assertTrue(produceWordTheSameMorseCode(phrasesConcatenated, morseCodeStr));
    }

    @Test
    public void testSlovakSentence() {
        MorseCodeTreeDecoder decodeTree = new MorseCodeTreeDecoder();
//        decodeTree.initWithEnglishDictionary();

        String original = "ahoj janka dnes je pekny den";
        String morseCodeStr = MorseCodeEncoder.textToMorseCode(original);
        insertIntoMorseCodeDecodeTree(decodeTree, original);

        decodeTree.morseCodeToText(morseCodeStr);
        Set<String> phrasesConcatenated = decodeTree.morseCodeToTextConcatenated(morseCodeStr);
        Assert.assertTrue(phrasesConcatenated.contains(original));
    }

    private void insertIntoMorseCodeDecodeTree(MorseCodeTreeDecoder decodeTree, String text) {
        for (String word: text.split(" ")) {
            word = word.trim();
            decodeTree.insert(word);
        }
    }

    private Set<String> constructPhrases(List<List<Set<String>>> result) {

        Set<String> foundWords = new HashSet<>();

        for (List<Set<String>> orderedSets: result) {

            Set<String> finalWords = new HashSet<>();

            for (Set<String> wordsSet: orderedSets) {
                if (finalWords.isEmpty()) {
                    finalWords.addAll(wordsSet);
                } else {
                    Set<String> newSet = new HashSet<>();
                    Set<String> finalSet = new HashSet<>(finalWords);
                    wordsSet.forEach(s -> {
                        finalSet.forEach(previousWord -> {
                            if (previousWord.length() > 0) {
                                previousWord = previousWord + " ";
                            }
                            newSet.add(previousWord + s);
                        });
                    });
                    finalWords = newSet;
                }
            }

            foundWords.addAll(finalWords);
        }

        return foundWords;
    }

    private boolean produceWordTheSameMorseCode(Set<String> phrases, String morseCode) {

        for (String phrase: phrases) {
            if (!MorseCodeEncoder.textToMorseCode(phrase).equals(morseCode)) {
                return false;
            }
        }

        return true;
    }

    private void assertCorrectResult(List<List<Set<String>>> results, String morseCode) {

        for (List<Set<String>> orderedResult: results) {

            StringBuilder sbConcatWords = new StringBuilder();

            for (Set<String> wordsWithSameCodes : orderedResult) {
                boolean areTheSame = areCodesTheSame(wordsWithSameCodes);
                if (!areTheSame) {
                    Assert.fail();
                }

                sbConcatWords.append(wordsWithSameCodes.toArray(new String[0])[0]);
            }

            String morseCodeFromResult = MorseCodeEncoder.textToMorseCode(sbConcatWords.toString());
            if (!morseCodeFromResult.equals(morseCode)) {
                Assert.fail();
            }
        }
    }

    private boolean areCodesTheSame(Set<String> words) {

        String previousWord = null;
        String previousMorseCode = null;
        for (String currentWord: words) {
            String currentWordCode = MorseCodeEncoder.textToMorseCode(currentWord);

            if (previousMorseCode != null && !currentWordCode.equals(previousMorseCode)) {
                System.out.println("Words and codes does not match:");
                System.out.println(previousMorseCode + "  " + currentWordCode);
                System.out.println(previousWord + "  " + currentWord);
                return false;
            }

            previousWord = currentWord;
            previousMorseCode = currentWordCode;
        }

        return true;
    }
}
