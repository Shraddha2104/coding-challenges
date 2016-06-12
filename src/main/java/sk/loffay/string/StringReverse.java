package sk.loffay.string;

/**
 * @author Pavol Loffay
 */
public class StringReverse {

    public static char[] reverse(char string[]) {

        for (int i = 0; i < string.length/2; i++) {
            swap(string, i, string.length - 1 - i);
        }

        return string;
    }

    /**
     * Reverse words in string in place
     */
    public static char[] reverseWords(char string[]) {

        // reverse whole string
        reverseString(string, 0, string.length - 1);

        //reverse words
        int leftIndex = 0;
        for (int i = 0; i <= string.length; i++) {
            if (i == string.length || string[i] == ' ') {
                reverseString(string, leftIndex, i-1);
                leftIndex = i + 1;
            }
        }

        return string;
   }

   private static void reverseString(char[] string, int start, int end) {
       for (int i = start; i < start + (end - start + 1)/2; i++) {
           swap(string, i, end - (i - start));
       }
   }

   private static void swap(char string[], int i, int j) {
       char temp = string[j];
       string[j] = string[i];
       string[i] = temp;
   }
}
