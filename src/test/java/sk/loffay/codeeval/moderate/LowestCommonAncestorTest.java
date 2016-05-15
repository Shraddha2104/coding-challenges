package sk.loffay.codeeval.moderate;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class LowestCommonAncestorTest extends TestCase {

    @Test
    public void testFindAncestor() throws Exception {

        LowestCommonAncestor.Node root = LowestCommonAncestor.init();

        LowestCommonAncestor.Node ancestor = LowestCommonAncestor.lowestCommonAncestor(root, 52, 10);
        Assert.assertEquals(30, ancestor.getValue());

        Assert.assertEquals(20, LowestCommonAncestor.lowestCommonAncestor(root, 10, 29).getValue());
        Assert.assertEquals(20, LowestCommonAncestor.lowestCommonAncestor(root, 29, 10).getValue());
        Assert.assertEquals(8, LowestCommonAncestor.lowestCommonAncestor(root, 3, 29).getValue());
        Assert.assertEquals(20, LowestCommonAncestor.lowestCommonAncestor(root, 10, 20).getValue());
        Assert.assertEquals(30, LowestCommonAncestor.lowestCommonAncestor(root, 3, 52).getValue());
        Assert.assertEquals(30, LowestCommonAncestor.lowestCommonAncestor(root, 30, 30).getValue());
        Assert.assertEquals(8, LowestCommonAncestor.lowestCommonAncestor(root, 3, 20).getValue());
        Assert.assertEquals(30, LowestCommonAncestor.lowestCommonAncestor(root, 30, 10).getValue());
    }

    @Test
    public void testCodeEval() throws IOException {
        CodeevalTestUtils.testMain("moderate/lowestCommonAncestor", (args) -> {
            try {
                LowestCommonAncestor.main(args);
            } catch (IOException ex) {
            }
        });
    }
}
