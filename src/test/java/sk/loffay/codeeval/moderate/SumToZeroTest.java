package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
@Ignore
public class SumToZeroTest {

    @Test
    public void test() {
        Assert.assertEquals(2, SumToZero.sumToZero("2,3,1,0,-4,-1"));
        Assert.assertEquals(1, SumToZero.sumToZero("0,-1,3,-2"));
        Assert.assertEquals(0, SumToZero.sumToZero("0,-44,3,-2"));
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
