package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Pavol Loffay
 */
public class SimpleCalculator {

  public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));
    String line;
    while ((line = buffer.readLine()) != null) {
      line = line.trim();
      // Process line of input Here
      NumberFormat numberFormat = NumberFormat.getInstance();
      numberFormat.setMaximumFractionDigits(5);
      numberFormat.setGroupingUsed(false);
      System.out.println(numberFormat.format(infixCalculator(line)));
    }
  }

  static Double infixCalculator(String line) {
    return evaluatePostfix(infixToPostfix(line));
  }

  static double evaluatePostfix(String line) {
    Deque<Double> deque = new ArrayDeque<>();
    for (int i = 0; i < line.length();) {
      if (isOperator(line.charAt(i))) {
        switch (line.charAt(i)) {
          case '+':
            deque.push(deque.pop() + deque.pop());
            break;
          case '-': {
            double b = deque.pop();
            double a = deque.pop();
            deque.push(a - b);
          }
          break;
          case '*':
            deque.push(deque.pop() * deque.pop());
            break;
          case '/': {
            double b = deque.pop();
            double a = deque.pop();
            deque.push(a / b);
          }
          break;
          case '^': {
            double b = deque.pop();
            double a = deque.pop();
            deque.push(Math.pow(a, b));
          }
          break;
          case '#': {
            deque.push(-deque.pop());
          }
          break;
        }
        i++;
      } else if (line.charAt(i) == ' ') {
        i++;
      } else {
        StringBuilder sb = new StringBuilder();
        while (i < line.length() && (Character.isDigit(line.charAt(i)) || line.charAt(i) == '.')) {
          sb.append(line.charAt(i));
          i++;
        }
        deque.push(Double.parseDouble(sb.toString()));
      }
    }
    return deque.pop();
  }

  /**
   * translates infix notation to postfix
   *
   * unary - is #
   * adds space after each number
   */
  private static String infixToPostfix(String line) {
    Deque<Character> deque = new ArrayDeque<>();
    StringBuilder postfixResult = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char ch = line.charAt(i);

      switch (ch) {
        case '+':
        case '-':
          if (ch == '-' &&
              i == 0 || (i > 0 && (isOperator(line.charAt(i-1)) || line.charAt(i-1) == '('))) {
            // is unary minus
            deque.push('#');
          } else {

            postfixResult.append(' ');
            while (!deque.isEmpty() && isOperator(deque.peek())) {
              postfixResult.append(deque.pop());
            }
            deque.push(ch);
          }
          break;
        case '*':
        case '/':
          postfixResult.append(' ');
          while (!deque.isEmpty() && (deque.peek() == '*' || deque.peek() == '/' || deque.peek() == '^')) {
            postfixResult.append(deque.pop());
          }
          deque.push(ch);
          break;
        case '^':
          while (!deque.isEmpty() && (deque.peek() == '#')) {
            postfixResult.append(deque.pop());
          }
          postfixResult.append(' ');
          deque.push(ch);
          break;
        case '(':
          deque.push(ch);
          break;
        case ')':
          while (!deque.isEmpty() && deque.peek() != '(') {
            postfixResult.append(deque.pop());
          }
          deque.pop();
          break;
        case ' ' :
          break;
        default:
          // number
          postfixResult.append(ch);
          break;
      }
    }

    while (!deque.isEmpty()) {
      postfixResult.append(deque.pop());
    }

    return postfixResult.toString();
  }

  private static boolean isOperator(char ch) {
    if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^' || ch == '#') {
      return true;
    }
    return false;
  }
}
