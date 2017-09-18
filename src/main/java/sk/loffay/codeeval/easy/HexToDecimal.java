package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class HexToDecimal {

  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));

    String line;
    while ((line = buffer.readLine()) != null) {
      System.out.println(hexToDec(line));
    }
  }

  public static int hexToDec(String line) {
      line = line.trim().toUpperCase();
      int mul = 1;
      int num = 0;
      for (int i = line.length() - 1; i >= 0; i--) {
        char ch = line.charAt(i);
        if (!((ch >= 'A' && ch <= 'F') || (ch >= '0' && ch <= '9'))) {
          throw new IllegalArgumentException();
        }

        num += (ch <= '9') ? (ch - 48)*mul : (ch - 55)*mul;
        mul *= 16;
      }

      return num;
  }
}
