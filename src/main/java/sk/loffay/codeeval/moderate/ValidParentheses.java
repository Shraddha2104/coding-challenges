package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Pavol Loffay
 */
public class ValidParentheses {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            boolean valid = validParenthesis(line);
            System.out.println(valid ? "True" : "False");
        }
    }

    public static boolean validParenthesis(String line) {
        LinkedList<Character> parenthesisStack = new LinkedList<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(' ||
                    line.charAt(i) == '{' ||
                    line.charAt(i) == '[') {

                parenthesisStack.push(line.charAt(i));
            } else {

                Character top = parenthesisStack.peek();
                if (top == null) {
                    return false;
                }
                parenthesisStack.pop();

                boolean match = parenthesisMatch(line.charAt(i), top);
                if (match == false) {
                    return false;
                }
            }
        }

        return parenthesisStack.isEmpty();
    }

    private static boolean parenthesisMatch(char closing, char opening) {
        if (opening == '(' && closing == ')') {
            return true;
        }

        if (opening == '{' && closing == '}') {
            return true;
        }

        if (opening == '[' && closing == ']') {
            return true;
        }

        return false;
    }
}
