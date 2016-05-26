package sk.loffay;

/**
 * @author Pavol Loffay
 */
public interface Factorial {

    int factorial(int num);

    class IterativeFactorial implements Factorial {

        @Override
        public int factorial(int num) {

            if (num == 0) {
                return 1;
            }

            int factorial = Math.abs(num);
            for (int i = Math.abs(num) - 1; i > 1; i--) {
                factorial *= i;
            }

            return num < 0 ? -factorial : factorial;
        }
    }

    class RecursiveFactorial implements Factorial {

        @Override
        public int factorial(int num) {
            if (num == 0) {
                return 1;
            }
            return num * factorial(Math.abs(num) - 1);
        }
    }
}
