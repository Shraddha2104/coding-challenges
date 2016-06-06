package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StackImplementationTest {

    @Test
    public void test() {
        Assert.assertEquals("", StackImplementation.result(new Integer[]{}));
        Assert.assertEquals("0", StackImplementation.result(new Integer[]{0}));
        Assert.assertEquals("4 2", StackImplementation.result(new Integer[]{1, 2, 3, 4}));
        Assert.assertEquals("4 -2", StackImplementation.result(new Integer[]{10, -2, 3, 4}));
    }
}
