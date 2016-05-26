package sk.loffay;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FactorialTest {

    @Test
    public void testFactorial() {

        Factorial factorial = new Factorial.RecursiveFactorial();

        Assert.assertEquals(1, factorial.factorial(0));

        Assert.assertEquals(1, factorial.factorial(1));
        Assert.assertEquals(2, factorial.factorial(2));
        Assert.assertEquals(362880, factorial.factorial(9));

//        Assert.assertEquals(-1, factorial(-0));
        Assert.assertEquals(-1, factorial.factorial(-1));
        Assert.assertEquals(-362880, factorial.factorial(-9));
    }
}
