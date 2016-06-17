package sk.loffay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavol Loffay
 */
public interface Fibonacci {

    long fibonacci(int n);
    long fibonacciSum(int n);

    abstract class AbstractFibonacci implements Fibonacci {
        protected final int seed0;
        protected final int seed1;

        public AbstractFibonacci() {
            this(0, 1);
        }

        public AbstractFibonacci(int seed0, int seed1) {
            this.seed0 = seed0;
            this.seed1 = seed1;
        }
    }

    @Tags("recursion")
    class RecursiveFibonacci extends AbstractFibonacci {

        public RecursiveFibonacci() {
            super();
        }

        public RecursiveFibonacci(int seed0, int seed1) {
            super(seed0, seed1);
        }

        @Override
        public long fibonacci(int n) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1;
            }

            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        @Override
        public long fibonacciSum(int n) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1;
            }

            return fibonacci(n - 1) + fibonacci(n - 2) + fibonacciSum(n - 1);
        }
    }

    class IterativeFibonacci extends AbstractFibonacci {

        public IterativeFibonacci() {
            super();
        }

        public IterativeFibonacci(int seed0, int seed1) {
            super(seed0, seed1);
        }

        @Override
        public long fibonacci(int n) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1;
            }

            int previous = seed0;
            int result = seed1;
            for (int i = 0; i < n - 1; i++) {
                int oldResult = result;
                result = previous + result;
                previous = oldResult;
            }

            return result;
        }

        @Override
        public long fibonacciSum(int n) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1 + seed0;
            }

            int previousPrevious = seed0;
            int previous = seed1;
            int result = seed1;
            for (int i = 0; i < n - 1; i++) {
                int fib = previous + previousPrevious;
                result += fib;

                previousPrevious = previous;
                previous = fib;
            }

            return result;
        }
    }

    @Tags("dynamic programming")
    class DynamicFibonacci extends AbstractFibonacci {

        public DynamicFibonacci() {
            super();
        }

        public DynamicFibonacci(int seed0, int seed1) {
            super(seed0, seed1);
        }

        @Override
        public long fibonacci(int n) {
            Map<Integer, Long> results = new HashMap<>();
            dynamicFibonacci(n, results);

            return dynamicFibonacci(n, results);
        }

        private long dynamicFibonacci(int n, Map<Integer, Long> results) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1;
            }

            Long result =  results.get(n);
            if (result == null) {
                result = dynamicFibonacci(n - 1, results) + dynamicFibonacci(n - 2, results);
                results.put(n, result);
            }

            return result;
        }


        @Override
        public long fibonacciSum(int n) {
            Map<Integer, Long> results = new HashMap<>();
            return dynamicFibonacciSum(n, results);
        }

        private long dynamicFibonacciSum(int n, Map<Integer, Long> results) {
            if (n == 0) {
                return seed0;
            } else if (n == 1) {
                return seed1;
            }

            Long result = results.get(n);
            if (result == null) {
                Map<Integer, Long> resultFib = new HashMap<>();
                result = dynamicFibonacci(n - 1, resultFib) + dynamicFibonacci(n - 2, resultFib) +
                        dynamicFibonacciSum(n - 1, results);

                results.put(n, result);
            }

            return result;
        }
    }
}
