package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class LocksTest {

    @Test
    public void test() {
        Assert.assertEquals(2, Locks.numberOfOpenDoors(3, 1));
        Assert.assertEquals(50, Locks.numberOfOpenDoors(100, 100));
    }
}
