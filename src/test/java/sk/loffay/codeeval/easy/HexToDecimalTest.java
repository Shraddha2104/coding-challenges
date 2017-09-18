package sk.loffay.codeeval.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class HexToDecimalTest {

  @Test
  public void test() {
    assertEquals(41743, HexToDecimal.hexToDec("a30f"));
  }
}
