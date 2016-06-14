package sk.loffay.other;

/**
 * @author Pavol Loffay
 */
public class FactorialZeros {

    public static int numberOfZerosAtTheEnd(int factorial) {

        int numberOfZeros = 0;
        for (int i = 1; i <= factorial; i++) {
            if (i%(5) == 0) {
                numberOfZeros++;
            }

            int k = 2;
            long pow = Double.valueOf(Math.pow(5, k)).longValue();
            while (pow <= i) {
                if (i%pow == 0) {
                    numberOfZeros++;
                }

                k++;
                pow = Double.valueOf(Math.pow(5, k)).longValue();
            }
        }

        return numberOfZeros;
    }
}
