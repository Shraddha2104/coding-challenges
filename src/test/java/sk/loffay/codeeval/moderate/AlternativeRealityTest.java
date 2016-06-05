package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class AlternativeRealityTest {

    @Test
    public void testCombinationsStack() {
        Assert.assertEquals(292, AlternativeReality.combinationsStack(100));
        Assert.assertEquals(1, AlternativeReality.combinationsStack(4));
        Assert.assertEquals(6, AlternativeReality.combinationsStack(17));
    }

    @Test
    public void testCombinationsRecursion() {
        Assert.assertEquals(292, AlternativeReality.combinations(100));
        Assert.assertEquals(1, AlternativeReality.combinations(4));
        Assert.assertEquals(6, AlternativeReality.combinations(17));
    }

    @Test
    public void testOne() {
        System.out.println(AlternativeReality.combinations(12));
    }
}
