package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class CountingPrimesTest {

    @Test
    public void test() {
        Assert.assertEquals(0, CountingPrimes.countOfPrimes(0, 1));
        Assert.assertEquals(1, CountingPrimes.countOfPrimes(1, 2));
        Assert.assertEquals(0, CountingPrimes.countOfPrimes(1, 1));
        Assert.assertEquals(1, CountingPrimes.countOfPrimes(2, 2));
        Assert.assertEquals(4, CountingPrimes.countOfPrimes(2, 10));
        Assert.assertEquals(2, CountingPrimes.countOfPrimes(20, 30));

        System.out.println(CountingPrimes.countOfPrimes(95,237));
    }
}
