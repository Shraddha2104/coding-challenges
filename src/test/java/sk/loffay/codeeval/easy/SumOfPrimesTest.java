package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SumOfPrimesTest {

    @Test
    public void test() {
        Assert.assertEquals(3682913, SumOfPrimes.sumOfFirstPrimes(1000));
        Assert.assertEquals(2, SumOfPrimes.sumOfFirstPrimes(1));
        Assert.assertEquals(0, SumOfPrimes.sumOfFirstPrimes(0));
    }
}
