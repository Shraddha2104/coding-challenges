package sk.loffay.codility;

/**
 * @author Pavol Loffay
 *
 * 100 %
 */
public class BinarySumOfOnesSonarSource {

    public int solution(final int a, int b) {

        if (a < 0 || a > 100000000 ||
                b < 0 || b > 100000000) {
            throw new IllegalArgumentException("Incorrect input a,b should be > 0 and < 100000000");
        }

        int result = 0;
        int sum = 0;

        while (b > 0) {

            // odd  - should add A
            if ((b&1) == 1) {
                sum += a;
            }

            if (((sum)&1) > 0) {
                result++;
            }

            sum = sum>>1;
            b = b>>1;
        }

        while (sum > 0) {
            if ((sum&1) == 1) {
                result++;
            }
            sum = sum>>1;
        }

        return result;
    }
}
