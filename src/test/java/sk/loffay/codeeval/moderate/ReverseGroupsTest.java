package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ReverseGroupsTest {

    @Test
    public void test() {
//        Assert.assertEquals("2,1,4,3,5", ReverseGroups.reverseGroups("1,2,3,4,5;2"));
        Assert.assertEquals("3,2,1,4,5", ReverseGroups.reverseGroups("1,2,3,4,5;3"));
    }
}
