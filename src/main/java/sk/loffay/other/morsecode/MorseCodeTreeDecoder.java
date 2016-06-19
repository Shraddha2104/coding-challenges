package sk.loffay.other.morsecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import sk.loffay.netsute.Dictionary;

/**
 * Tree contains morse code encoded words from Dictionary (It might not contain all English words!)
 *
 * on the left is .
 * on the right is -
 *
 * @author Pavol Loffay
 */
public class MorseCodeTreeDecoder {

    private static final Pattern VALID_INSERT = Pattern.compile("[a-zA-Z0-9]+");

    private Node root;


    public void initWithEnglishDictionary() {
        for (String word: Dictionary.WORDS_DYNAMIC_GENERATED) {
            insert(word);
        }
    }

    /**
     * Inserts any valid English word
     *
     * 1. translate word into morse code
     * 2. insert to appropriate position in the tree
     */
    public void insert(String word) {
        if (!VALID_INSERT.matcher(word).matches()) {
            throw new IllegalArgumentException(word + " should match [a-zA-Z0-9]+");
        }

        String morseCode = MorseCodeEncoder.textToMorseCode(word);
        root = insert(root, morseCode, 0, word);
    }

    private Node insert(Node node, final String morseCode, int index, final String original) {
        if (node == null) {
            node = new Node();
        }

        if (index < morseCode.length()) {
            if (morseCode.charAt(index) == '.') {
                node.left = insert(node.left, morseCode, index + 1, original);
            } else {
                node.right = insert(node.right, morseCode, index + 1, original);
            }
        } else {
            node.words.add(original);
        }

        return node;
    }

    /**
     * Converts one word in morse code to longest word
     * note that possibly more results are correct
     */
    public Set<String> toLongestWord(String morseCode) {
        return getWord(root, morseCode, 0);
    }

    /**
     * Method returns words for given morse code
     * Does not do backtracking
     */
    private Set<String> getWord(Node node, String morseCode, int index) {
        if (node == null) {
            return Collections.emptySet();
        }

        return index != morseCode.length() ?
                getWord(morseCode.charAt(index) == '.' ? node.left : node.right, morseCode, index + 1) :
                Collections.unmodifiableSet(node.words);
    }

    /**
     * Converts morse code to text (even more words separated by spaces)
     * returns all phrases that can be represented as input morse code
     */
    public Set<String> morseCodeToTextConcatenated(String morseCode) {
        return getTextConcatenated(root, morseCode, 0);
    }

    /**
     * @see MorseCodeTreeDecoder#morseCodeToTextConcatenated(String)
     */
    public List<List<Set<String>>> morseCodeToText(String morseCode) {
        return getText(root, morseCode, 0);
    }

    private List<List<Set<String>>> getText(Node node, String morseCode, int index) {

        if (node != null) {
            if (index == morseCode.length()) {
                if (!node.words.isEmpty()) {
                    // found all sequence
                    List<Set<String>> orderedSet = new LinkedList<>();
                    orderedSet.add(new HashSet<>(node.words));
                    List<List<Set<String>>> res = new LinkedList<>();
                    res.add(orderedSet);
                    return res;
                }
            } else {
                List<List<Set<String>>> res = getText(morseCode.charAt(index) == '.' ?
                        node.left : node.right, morseCode, index + 1);

                // if node contains words, try from root
                if (!node.words.isEmpty()) {
                    List<List<Set<String>>> added = getText(root, morseCode, index);
                    if (!added.isEmpty()) {
                        for (List<Set<String>> linkedList: added) {
                            ((LinkedList<Set<String>>)linkedList).push(node.words);
                        }

                        res.addAll(added);
                    }
                }

                return res;
            }
        }

        return new ArrayList<>();
    }

    private Set<String> getTextConcatenated(Node node, String morseCode, int index) {

        if (node != null) {
            if (index == morseCode.length()) {
                if (!node.words.isEmpty()) {
                    return new HashSet<>(node.words);
                }
            } else {
                Set<String> res = getTextConcatenated(morseCode.charAt(index) == '.' ?
                        node.left :
                        node.right, morseCode, index + 1);

                // if node contains words, try from root
                if (!node.words.isEmpty()) {
                    Set<String> added = getTextConcatenated(root, morseCode, index);
                    if (!added.isEmpty()) {

                        Set<String> addedNew = new HashSet<>();
                        for (String word: node.words) {
                            for (String addedWord: added) {
                                addedNew.add(word + " " + addedWord);
                            }
                        }

                        res.addAll(addedNew);
                    }
                }

                return res;
            }
        }

        return new HashSet<>();
    }

    /**
     * Tree for morse code
     */
    private static class Node {
        Set<String> words = new HashSet<>();
        Node left;
        Node right;
    }
}
