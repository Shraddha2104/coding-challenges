package sk.loffay.string;

/**
 * @author Pavol Loffay
 */
public class StringConversions {

    public static int toInteger(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("String is not valid number!");
        }

        int result = 0;

        boolean negative = false;
        for (int i = 0; i < string.length(); i++) {
            //negative check
            if (i == 0 && string.charAt(0) == '-') {
                negative = true;
                continue;
            }

            if (string.charAt(i) < 48 || string.charAt(i) > 57) {
                throw new IllegalArgumentException("String is not valid number!");
            }

            result *= 10;
            result += string.charAt(i) - 48;
        }

        return negative ? -result : result;
    }

    public static String toString(int number) {
        if (number == 0) {
            return "0";
        }

        boolean negative = number < 0 ? true : false;
        number = number < 0 ? -number : number;

        StringBuilder stringBuilder = new StringBuilder();

        while (number > 0) {
            int reminder = number%10;
            number = number/10;
            stringBuilder.insert(0, reminder);
        }

        return negative ? "-" + stringBuilder : stringBuilder.toString();
    }
}
