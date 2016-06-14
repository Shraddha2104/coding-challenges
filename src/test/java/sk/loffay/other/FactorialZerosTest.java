package sk.loffay.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FactorialZerosTest {

    @Test
    public void test() {
        Assert.assertEquals(0, FactorialZeros.numberOfZerosAtTheEnd(1));
        Assert.assertEquals(2, FactorialZeros.numberOfZerosAtTheEnd(10));
        Assert.assertEquals(24, FactorialZeros.numberOfZerosAtTheEnd(100));
        Assert.assertEquals(31, FactorialZeros.numberOfZerosAtTheEnd(125));
        Assert.assertEquals(74, FactorialZeros.numberOfZerosAtTheEnd(300));
    }
}
