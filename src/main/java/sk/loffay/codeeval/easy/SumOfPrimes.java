package sk.loffay.codeeval.easy;

/**
 * @author Pavol Loffay
 */
public class SumOfPrimes {

    public static void main(String[] args) {
        System.out.println(sumOfFirstPrimes(1000));
    }

    public static long sumOfFirstPrimes(int n) {
        if (n <= 0) {
            return 0;
        }

        long result = 0;
        long number = 2;

        while (n > 0) {
            boolean isPrime = true;
            long k = 2;
            while (k < number) {
                if (number%k == 0) {
                    isPrime = false;
                    break;
                }
                k++;
            }

            if (isPrime) {
                result += number;
                n--;
            }

            number++;
        }

        return result;
    }
}
