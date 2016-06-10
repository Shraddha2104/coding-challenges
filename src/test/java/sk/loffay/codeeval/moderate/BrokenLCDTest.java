package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class BrokenLCDTest {

    @Test
    public void test() {
//        Assert.assertEquals(true, BrokenLCD.isAbleToDisplay("84.525784", toSegments("10110001 11111000 11111110 11111111 11111111 11111111 11111111 11101101 11111111 01111111 11110010 10100111")));
        Assert.assertEquals(true, BrokenLCD.isAbleToDisplay("5.57", toSegments("11111111 11110110 11101111 11110111 10111110 11110110 10111011 10100111 11111100 01100100 11111101 01011110")));
//        Assert.assertEquals(true, BrokenLCD.isAbleToDisplay("857.71284", toSegments("11000010 00001111 11111111 10111111 11101011 11110011 01111110 11011111 11111111 11111111 11111001 01101110")));

        Assert.assertEquals(false, BrokenLCD.isAbleToDisplay("66.92", toSegments("11111111 01110111 10111011 11001101 11111011 11101010 11110100 01001101 11011111 11111010 10010110 10111111")));
        Assert.assertEquals(false, BrokenLCD.isAbleToDisplay("188.87", toSegments("11111011 10010001 11111011 11111101 10011111 10111110 01111100 11011101 10111001 11111110 11101111 11110110")));
//        Assert.assertEquals(, BrokenLCD.isAbleToDisplay("", toSegments("")));
    }

    private static String[] toSegments(String input) {
        String[] segments = input.trim().split(" ");
        return segments;
    }
}
