package sk.loffay.codeeval.moderate;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class DetectingCyclesTest extends TestCase {

    @Test
    public void testDetectFirstCycle() throws Exception {
        int[] arr = {2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1};

        int[] cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{6, 3, 1}, cycle);

        arr = new int[]{3, 4, 8, 0, 11, 9, 7, 2, 5, 6, 10, 1, 49, 49, 49, 49};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{49}, cycle);

        arr = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, cycle);
    }

    @Test
    public void testCornerCases() {
        int[] arr = new int[]{};
        int[] cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{}, cycle);

        arr = new int[]{1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{}, cycle);

        arr = new int[]{1, 1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1}, cycle);

        arr = new int[]{1, 0, 1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{}, cycle);

        arr = new int[]{1, 1, 0, 1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1}, cycle);

        arr = new int[]{1, 2, 0, 1,1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1}, cycle);

        arr = new int[]{1, 2, 3, 4, 1,2,3};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{}, cycle);

        arr = new int[]{1, 2, 3, 4, 1,2,3, 23, 23};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{23}, cycle);

        arr = new int[]{1, 2, 3, 4, 1,2,3, 23, 1, 2,3, 1,2,3};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1,2,3}, cycle);

        arr = new int[]{1, 2, 3, 4, 1,2,3, 23, 1, 2,3, 1,2,4, 2, 3,3};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{3}, cycle);

        arr = new int[]{1,1, 2, 3, 4, 1,2,3, 23, 1, 2,3, 1,2,4, 2, 3,3};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{1}, cycle);

        arr = new int[]{0, 3, 2, 1, 2, 1, 2, 1};
        cycle = DetectingCycles.detectFirstCycle(arr);
        Assert.assertArrayEquals(new int[]{2, 1}, cycle);
    }

    @Test
    public void testCodeEvalTestData() throws IOException {
        TestUtils.testMain("detectingCycles", (args) -> {
            try {
                DetectingCycles.main(args);
            } catch (IOException ex) {
            }
        });
    }
}
