package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class MinimumCoinsTest {

    @Test
    public void test() {
        Assert.assertEquals(0, MinimumCoins.totalNumberOfCoins(0));
        Assert.assertEquals(1, MinimumCoins.totalNumberOfCoins(1));
        Assert.assertEquals(2, MinimumCoins.totalNumberOfCoins(2));
        Assert.assertEquals(3, MinimumCoins.totalNumberOfCoins(13));
        Assert.assertEquals(3, MinimumCoins.totalNumberOfCoins(11));
        Assert.assertEquals(4, MinimumCoins.totalNumberOfCoins(20));
        Assert.assertEquals(11, MinimumCoins.totalNumberOfCoins(51));
    }

}
