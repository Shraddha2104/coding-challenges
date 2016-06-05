package sk.loffay.codeeval.moderate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class NumberOperationsTest {

    @Test
    public void testNumberPermutations() {
        List<List<Integer>> permu = NumberOperations.numberPermutations(Arrays.asList(1, 5, 3, 2));
        Assert.assertEquals(24, permu.size());
    }

    @Test
    public void testOperatorsSize() {
        List<List<Character>> operators = NumberOperations.operators(new LinkedList<>());
        Assert.assertEquals(81, operators.size());
    }
}
