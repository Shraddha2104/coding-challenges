package sk.loffay.codeeval.moderate;

import static sk.loffay.codeeval.moderate.SumToZero.combinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
public class SumToZeroTest {

    @Test
    public void test() {
        Assert.assertEquals(2, SumToZero.sumToZero("2,3,1,0,-4,-1"));
        Assert.assertEquals(1, SumToZero.sumToZero("0,-1,3,-2"));
        Assert.assertEquals(0, SumToZero.sumToZero("0,-44,3,-2"));
    }

    @Test
    public void testCombinations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Assert.assertEquals(1, combinations(numbers, 4).size());
        Assert.assertEquals(4, combinations(numbers, 3).size());
        Assert.assertEquals(6, combinations(numbers, 2).size());
        Assert.assertEquals(4, combinations(numbers, 1).size());
    }

    @Test
    public void testCodeEval() throws FileNotFoundException {
        CodeevalTestUtils.testMain("moderate/sumToZero", (arg) -> {
            try {
                SumToZero.main(arg);
            } catch (IOException ex) {
            }
        });
    }
}
