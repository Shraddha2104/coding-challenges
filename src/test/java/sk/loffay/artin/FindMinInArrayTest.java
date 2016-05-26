package sk.loffay.artin;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FindMinInArrayTest {

    @Test
    public void testFindMinInArray() {
        int[] array = new int[] {
            9,9,7,0,1,-1
        };
        Assert.assertEquals(1, FindMinInArray.findMinInArray(array));

        array = new int[] {
                9,9,7,0,-1,1
        };
        Assert.assertEquals(1, FindMinInArray.findMinInArray(array));

        array = new int[] {
                9,9,7,0,3,-2, 3
        };
        Assert.assertEquals(-2, FindMinInArray.findMinInArray(array));
    }
}
