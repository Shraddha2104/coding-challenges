package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class BitPositionsTest {

    @Test
    public void test() {
        Assert.assertEquals(true, BitPositions.hasTheSameBitAtPositions(86, 2, 3));
        Assert.assertEquals(false, BitPositions.hasTheSameBitAtPositions(125, 1, 2));
        Assert.assertEquals(true, BitPositions.hasTheSameBitAtPositions(0, 1, 2));
    }
}
