package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class MTHToLastElementTest {

    @Test
    public void test() {
        Assert.assertEquals(Character.valueOf('a'), MTHToLastElement.mthLastElement("a b c d 4"));
        Assert.assertEquals(Character.valueOf('g'), MTHToLastElement.mthLastElement("e f g h 2"));
    }
}
