package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FibonacciSeriesTest {

    @Test
    public void test() {
        Assert.assertEquals(5, FibonacciSeries.fibonacci(5));
        Assert.assertEquals(144, FibonacciSeries.fibonacci(12));
    }

}
