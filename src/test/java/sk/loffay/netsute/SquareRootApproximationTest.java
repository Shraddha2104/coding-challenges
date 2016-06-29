package sk.loffay.netsute;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class SquareRootApproximationTest extends TestCase {

    @Test
    public void testSquareRoot() {
        double approximation = SquareRootApproximation.squareRoot(2, 1e-6);
        System.out.println(approximation);

        approximation = SquareRootApproximation.squareRoot(3, 1e-6);
        System.out.println(approximation);
    }

    @Test
    public void testZero() {
        double approximation = SquareRootApproximation.squareRoot(0, 1e-2);
        System.out.println(approximation);
    }
}
