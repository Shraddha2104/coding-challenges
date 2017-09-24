package sk.loffay.codeeval.moderate;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SimpleCalculatorTest {

  @Test
  public void test() {
    assertEquals(2, SimpleCalculator.infixCalculator("4/2"), 0);
    assertEquals(6, SimpleCalculator.infixCalculator("1+2+3"), 0);
    assertEquals(3575, SimpleCalculator.infixCalculator("250*14.3"), 0);
    assertEquals(8, SimpleCalculator.infixCalculator("2^3"), 0);
    assertEquals(729, SimpleCalculator.infixCalculator("3^6"), 0);
    assertEquals(6.23077, SimpleCalculator.infixCalculator("3^6 / 117"), 0.00001);
    assertEquals(-0.02165, SimpleCalculator.infixCalculator("(2.16 - 48.34)^-1"), 0.00001);
    assertEquals(62, SimpleCalculator.infixCalculator("(59 - 15 + 3*6)"), 0.00001);
    assertEquals(2.95238, SimpleCalculator.infixCalculator("(59 - 15 + 3*6)/21"), 0.00001);
  }

  @Test
  @Ignore
  public void testOne() {
    assertEquals(434352.2384, SimpleCalculator.infixCalculator("-((-((-512.37) * (-850.32))) + 930 - (-396.22))"), 0.00001);
    assertEquals(2491, SimpleCalculator.infixCalculator("-(48)+2539"), 0.00001);
    assertEquals(1825.25, SimpleCalculator.infixCalculator("-(48)+2539 + 326 - 991.75 - 311^(-243)"), 0.00001);
    assertEquals(0.125, SimpleCalculator.infixCalculator("(2)^(-3.00)"), 0.00001);
//    TODO this is not passing, does it overflow?
    assertEquals(105546689, SimpleCalculator.infixCalculator("-(48)+2539 + 326 - 991.75 - 311^(-243) * (-((-((-512.37) * (-850.32))) + 930 - (-396.22)))^(-356.00)"), 0.00001);
  }
}
