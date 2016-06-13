package sk.loffay.sonarsource;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class PrecedenceAnalysisTest {

    @Test
    public void testStringEvaluation() {
        String expression = "2+2";
        assertAndPrint(4, PrecedenceAnalysis.evaluate(expression));

        expression = "2*2/4/3+7-9";
        assertAndPrint(-2, PrecedenceAnalysis.evaluate(expression));
    }

    @Test
    public void testEvaluation() {
        String[] tokens = {
                "2", "+", "9", "+", "1"
        };
        assertAndPrint(12, PrecedenceAnalysis.evaluate(tokens));

        tokens = new String[] {
            "2", "*", "2"
        };
        assertAndPrint(4, PrecedenceAnalysis.evaluate(tokens));

        tokens = new String[] {
                "2", "*", "2", "+", "1"
        };
        assertAndPrint(5, PrecedenceAnalysis.evaluate(tokens));

        tokens = new String[] {
                "2", "*", "2", "+", "1", "*", "3", "+", "7"
        };
        assertAndPrint(14, PrecedenceAnalysis.evaluate(tokens));

        tokens = new String[] {
                "2", "*", "2", "/", "4", "/", "3", "+", "7", "-", "9"
        };
        assertAndPrint(-2, PrecedenceAnalysis.evaluate(tokens));
    }

    @Test
    public void testCornerCases() {
        String[] tokens = {
                "2", "+", "9", "+", "1"
        };
        assertAndPrint(0, PrecedenceAnalysis.evaluate(new String[0]));

        tokens = new String[] {
                "2", "*", "*", "2"
        };
        try {
            assertAndPrint(0, PrecedenceAnalysis.evaluate(tokens));
            Assert.fail();
        } catch (IllegalArgumentException ex){
            //ok
        }

        tokens = new String[] {
               "+", "2", "*", "*", "2"
        };
        try {
            assertAndPrint(0, PrecedenceAnalysis.evaluate(tokens));
            Assert.fail();
        } catch (IllegalArgumentException ex){
            //ok
        }
    }

    @Test
    public void testOne() {
        String[] tokens = new String[] {
                "2", "*", "2"
        };
        assertAndPrint(4, PrecedenceAnalysis.evaluate(tokens));

//        String[] tokens = new String[] {
//                "2", "*", "2", "+", "1", "*", "3", "+", "7"
//        };
//        assertAndPrint(14, PrecedenceAnalysis.evaluate(tokens));
    }

    private void assertAndPrint(int expected, int actual) {
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
