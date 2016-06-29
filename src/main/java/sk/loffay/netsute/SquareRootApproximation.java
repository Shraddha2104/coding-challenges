package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 *
 * QUESTION 3
 *
 * 1. Why can't the next estimate, xx, be computed as a / x, where x is the
 *    previous estimate?
 * 2. What happens, in your implementation, if a = 0?
 * 3. What value does your program give for square_root(2, 1e-6)?
 *
 * 1: Because it needs to go to the center
 * 2: 0
 * 3: squareRoot(2, double 1e-6) = 1.4142135623746899
 *
 */
public class SquareRootApproximation {

    public static double squareRoot(final double a, double epsilon) {

        // initial guess
        double guess = a/2.0;
        double average = guess;
        double quotient;

        do {
            guess = average;
            quotient = a/average;
            average = (quotient + guess)/2;

        } while (Math.abs(guess*guess - a) > epsilon);

        return guess;
    }
}
