package sk.loffay.sonarsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Pavol Loffay
 */
public class PrecedenceAnalysis {

    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    private PrecedenceAnalysis() {
    }

    public static int evaluate(String expression) {
//        String[] strTokens = expression.split(String.format(WITH_DELIMITER, "\\d"));
//        return evaluate(strTokens);
        return evaluate(new LinkedList<>(Arrays.asList(parseStringToTokens(expression))));
    }

    public static int evaluate(String[] stringTokens) {
        if (stringTokens == null || stringTokens.length == 0) {
            return 0;
        }

        Token[] tokensArr = parseTokens(stringTokens);
        LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(tokensArr));

        return evaluate(tokens);
    }

    private static int evaluate(LinkedList<Token> tokens) {

        int ip = 0;
        boolean cannotEvaluate = false;
        while (tokens.size() > 1) {

            Token token = tokens.get(ip);
            Token nextToken = ip + 1 < tokens.size() ? tokens.get(ip + 1) : null;
            Token nextNextToken = ip + 2 < tokens.size() ? tokens.get(ip + 2) : null;

            if (token.isOperator() && canEvaluate(nextNextToken, token)) {
                int result = evaluate(token, tokens.get(ip - 1), nextToken);

                tokens.set(ip, Token.number(result));
                tokens.remove(ip + 1);
                tokens.remove(ip - 1);

                ip = cannotEvaluate ? ip - 3 : ip - 1;
                cannotEvaluate = false;
            } else {
                if (token.isOperator() && !canEvaluate(nextNextToken, token)) {
                    cannotEvaluate = true;
                }
                ip++;
            }
        }

        return tokens.get(0).getNumber();
    }

    private static boolean canEvaluate(Token nextOperator, Token currentOperator) {
        if (nextOperator == null) {
            return true;
        }

        if (currentOperator.getType() == Token.Type.Plus || currentOperator.getType() == Token.Type.Minus) {
            return nextOperator.getType() == Token.Type.Minus || nextOperator.getType() == Token.Type.Plus;
        } else if (currentOperator.getType() == Token.Type.Division ||
                currentOperator.getType() == Token.Type.Multiplication) {
            return true;
        }

        throw new IllegalArgumentException("Cannot evaluate!");
    }

    private static int evaluate(Token operator, Token val1, Token val2) {
        if (val1.isOperator() || val2.isOperator()) {
            throw new IllegalArgumentException("Cannot evaluate");
        }

        int result;

        switch (operator.getType()) {
            case Plus: result = val1.getNumber()+val2.getNumber();
                break;
            case Minus: result = val1.getNumber()-val2.getNumber();
                break;
            case Multiplication: result = val1.getNumber()*val2.getNumber();
                break;
            case Division: result = val1.getNumber()/val2.getNumber();
                break;
            default:
                throw new IllegalArgumentException("Illegal operator");
        }

        return result;
    }

    public static Token[] parseTokens(String[] stringTokens) {
        Token[] tokens = new Token[stringTokens.length];

        for (int i = 0; i < stringTokens.length; i++) {
            tokens[i] = parseToken(stringTokens[i]);
        }

        return tokens;
    }

    private static Token parseToken(String strToken) {
        Token token = null;

        switch (strToken) {
            case "+":
                token = Token.plus();
                break;
            case "-":
                token = Token.minus();
                break;
            case "*":
                token = Token.multiplication();
                break;
            case "/":
                token = Token.division();
                break;
            default:
                try {
                    int number = Integer.parseInt(strToken);
                    token = Token.number(number);
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Illegal token " + strToken);
                }
        }

        return token;
    }

    private static Token[] parseStringToTokens(String expression) {
        char[] chars = expression.toCharArray();

        List<Token> tokens = new ArrayList<>();

        int numberLength = 0;
        for (int i = 0; i < chars.length; i++) {
            final char ch = chars[i];
            Token token;

            if (Character.isDigit(ch)) {
                numberLength++;
                continue;
            } else if (numberLength > 0 ) {
                tokens.add(Token.number(number(chars, i - numberLength, i)));
                numberLength = 0;
            }

            switch (ch) {
                case '+' : token = Token.plus();
                    break;
                case '-' : token = Token.minus();
                    break;
                case '*' : token = Token.multiplication();
                    break;
                case '/' : token = Token.division();
                    break;
                default:
                    throw new IllegalArgumentException("Illegal operator!");
            }

            tokens.add(token);
        }

        if (numberLength > 0) {
            Token token = Token.number(number(chars, chars.length - numberLength, chars.length));
            tokens.add(token);
        }

        return tokens.toArray(new Token[0]);
    }

    private static int number(char[] str, int from, int to) {
        char[] number = Arrays.copyOfRange(str, from, to);
        return  Integer.parseInt(String.copyValueOf(number));
    }
}
