package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class DoubleTroubleTest {

    @Test
    public void test() {
        System.out.print(DoubleTrouble.combinations("ABA*"));

        Assert.assertEquals(1, DoubleTrouble.combinations("ABA*"));
        Assert.assertEquals(0, DoubleTrouble.combinations("BAA*"));
        Assert.assertEquals(2, DoubleTrouble.combinations("A*A*"));
    }
}
