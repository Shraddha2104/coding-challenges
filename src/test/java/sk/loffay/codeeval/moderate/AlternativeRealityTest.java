package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class AlternativeRealityTest {

    @Test
    public void testCombinations() {
//        Assert.assertEquals(292, AlternativeReality.combinations(100));
//        Assert.assertEquals(1, AlternativeReality.combinations(4));
        Assert.assertEquals(6, AlternativeReality.combinations(17));
    }
}
