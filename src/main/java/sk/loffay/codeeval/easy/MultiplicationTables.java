package sk.loffay.codeeval.easy;

/**
 * @author Pavol Loffay
 */
public class MultiplicationTables {

  public static void main(String[] args) {

    for (int i = 1; i <= 12; i++) {
      StringBuilder sb = new StringBuilder();
      for (int iter = 1; iter <= 12; iter++) {
        int num = i*iter;
        for (int nSpace = 4 - numberOfNum(num); nSpace > 0; nSpace--) {
          sb.append(" ");
        }
        sb.append(num);
      }

      System.out.print(sb.append("\n").toString());
    }
  }

  private static int numberOfNum(int num) {
    int result = 0;

    while (num > 0) {
      num = num / 10;
      result++;
    }

    return result;
  }
}
