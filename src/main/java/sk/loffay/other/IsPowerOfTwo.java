package sk.loffay.other;

/**
 * @author Pavol Loffay
 */
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int number) {
        return (number & (number-1)) == 0;
    }
}
