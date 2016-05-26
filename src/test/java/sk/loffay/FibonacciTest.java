package sk.loffay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FibonacciTest {

    @Test
    public void testFib() {
        int seed0 = 0;
        int seed1 = 1;
        List<Fibonacci> fibonaccis = new ArrayList<>(Arrays.asList(new Fibonacci.IterativeFibonacci(seed0, seed1),
                new Fibonacci.RecursiveFibonacci(seed0, seed1)));

        for (Fibonacci fibonacci: fibonaccis) {
            Assert.assertEquals(seed0, fibonacci.fibonacci(0));
            Assert.assertEquals(seed1, fibonacci.fibonacci(1));

            Assert.assertEquals(5, fibonacci.fibonacci(5));
            Assert.assertEquals(8, fibonacci.fibonacci(6));
            Assert.assertEquals(13, fibonacci.fibonacci(7));
            Assert.assertEquals(21, fibonacci.fibonacci(8));
        }
    }

    @Test
    public void testFibSum() {
        int seed0 = 0;
        int seed1 = 1;
        List<Fibonacci> fibonaccis = new ArrayList<>(Arrays.asList(new Fibonacci.IterativeFibonacci(seed0, seed1),
                new Fibonacci.RecursiveFibonacci(seed0, seed1)));

        for (Fibonacci fibonacci: fibonaccis) {
            Assert.assertEquals(seed0, fibonacci.fibonacciSum(0));
            Assert.assertEquals(seed1, fibonacci.fibonacciSum(1));

            Assert.assertEquals(2, fibonacci.fibonacciSum(2));
            Assert.assertEquals(4, fibonacci.fibonacciSum(3));
            Assert.assertEquals(7, fibonacci.fibonacciSum(4));
            Assert.assertEquals(12, fibonacci.fibonacciSum(5));
            Assert.assertEquals(88, fibonacci.fibonacciSum(9));
        }
    }
}
