package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FindASquareTest {

    @Test
    public void test() {
        Assert.assertEquals(false, FindASquare.isSquare(FindASquare.parsePoints("(1,6), (6,7), (2,7), (9,1)")));
        Assert.assertEquals(false, FindASquare.isSquare(FindASquare.parsePoints("(4,1), (3,4), (0,5), (1,2)")));
        Assert.assertEquals(true, FindASquare.isSquare(FindASquare.parsePoints("(4,6), (5,5), (5,6), (4,5)")));
    }
}
