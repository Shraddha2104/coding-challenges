package sk.loffay.codility;


/**
 * @author Pavol Loffay
 *
 * 100 %
 */
class MaxElementArray {

    public int solution(int[] a) {

        int[] arrFront = new int[a.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            arrFront[i] = max;
        }

        int[] arrBack = new int[a.length];
        max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > max) {
                max = a[i];
            }
            arrBack[i] = max;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int x = Math.abs(arrFront[i] - arrBack[i]);

            if (x > result) {
                result = x;
            }
        }

        return result;
    }
}
