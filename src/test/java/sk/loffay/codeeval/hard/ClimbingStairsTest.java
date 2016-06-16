package sk.loffay.codeeval.hard;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ClimbingStairsTest {

    @Test
    public void test() {
        Assert.assertEquals(89, ClimbingStairs.nonRecursivePermutations(10));
        Assert.assertEquals(10946, ClimbingStairs.nonRecursivePermutations(20));

        Assert.assertEquals(89, ClimbingStairs.recursivePermutations(10));
        Assert.assertEquals(10946, ClimbingStairs.recursivePermutations(20));
    }

    /**
     * note that long overflows so the results are negative...
     */
    @Ignore
    @Test
    public void testMain() throws IOException {
        ClimbingStairs.main(new String[]{"/home/pavol/projects/sonar-source-interview-codility/src/test/resources/codeeval/hard/climbingStairs"});
    }
}
