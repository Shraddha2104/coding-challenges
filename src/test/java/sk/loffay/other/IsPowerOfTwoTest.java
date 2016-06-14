package sk.loffay.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class IsPowerOfTwoTest {

    @Test
    public void test() {
//        Assert.assertEquals(true, IsPowerOfTwo.isPowerOfTwo(1));
        Assert.assertEquals(true, IsPowerOfTwo.isPowerOfTwo(2));
        Assert.assertEquals(true, IsPowerOfTwo.isPowerOfTwo(4));
        Assert.assertEquals(true, IsPowerOfTwo.isPowerOfTwo(128));

        Assert.assertEquals(false, IsPowerOfTwo.isPowerOfTwo(17));
        Assert.assertEquals(false, IsPowerOfTwo.isPowerOfTwo(6));
        Assert.assertEquals(false, IsPowerOfTwo.isPowerOfTwo(9));
        Assert.assertEquals(false, IsPowerOfTwo.isPowerOfTwo(28));
    }
}
