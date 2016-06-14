package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class JollyJumpersTest {

    @Test
    public void test() {
//        Assert.assertEquals(false, JollyJumpers.jollyJumpers(new int[]{}));
//        Assert.assertEquals(true, JollyJumpers.jollyJumpers(new int[]{2}));
        Assert.assertEquals(true, JollyJumpers.jollyJumpers(new int[]{4, 1, 4, 2, 3}));
        Assert.assertEquals(false, JollyJumpers.jollyJumpers(new int[]{3, 7, 7, 8}));
        Assert.assertEquals(false, JollyJumpers.jollyJumpers(new int[]{9, 8, 9, 7, 10, 6, 12, 17, 24, 38}));
    }
}
