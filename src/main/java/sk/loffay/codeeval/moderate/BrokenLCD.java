package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class BrokenLCD {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(";");
            String numToDisplay =  split[1].trim();
            String[] segments = split[0].trim().split(" ");

            System.out.println(isAbleToDisplay(numToDisplay, segments) ? "1" : "0");
        }
    }

    public static boolean isAbleToDisplay(String number, String[] segments) {

        int[] intSegments = new int[segments.length];
        for (int i = 0; i < segments.length; i++) {
            String num = segments[i].substring(0, segments[i].length() - 1);
            intSegments[i] = Integer.parseInt(num, 2);
        }

        List<Number> digitsOfNumber = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            try {
                Integer parsedInt = Integer.parseInt(""+ number.charAt(i));
                parsedInt = changeBits(parsedInt);
                digitsOfNumber.add(new Number(parsedInt, false));
            } catch (NumberFormatException ex) {
                // it is dot
                digitsOfNumber.get(i-1).dot = true;
            }
        }

        int successfullyDisplayed = 0;
        for (int iSegment = 0; iSegment < intSegments.length; iSegment++) {

            successfullyDisplayed = 0;
            int iDigitSegmentIndex = iSegment;
            for (int iDigit = 0; iDigit < digitsOfNumber.size() && iDigitSegmentIndex < intSegments.length;) {

                boolean isAbleToDisplay = isAbleToDisplay(digitsOfNumber.get(iDigit), intSegments[iDigitSegmentIndex],
                        segments[iDigitSegmentIndex]);

                if (isAbleToDisplay) {
                    successfullyDisplayed++;
                    iDigit++;
                } else {
                    break;
                }

                iDigitSegmentIndex++;
            }

            if (successfullyDisplayed ==  digitsOfNumber.size()) {
                return true;
            }
        }

        return successfullyDisplayed == digitsOfNumber.size();
    }

    private static boolean isAbleToDisplay(Number number, int intSegment, String segment) {
        boolean isDotOk = true;
        if (number.dot) {
            isDotOk = segment.charAt(segment.length() - 1) == '1';
        }
        return (number.number & intSegment) == number.number && isDotOk;
    }

    public static int changeBits(int num) {
        int intNumber = 0;
        switch (num) {
            case 1 :
                intNumber = Integer.parseInt("0110000", 2);
                break;
            case 2 :
                intNumber = Integer.parseInt("1101101", 2);
                break;
            case 3 :
                intNumber = Integer.parseInt("1111001", 2);
                break;
            case 4 :
                intNumber = Integer.parseInt("0110011", 2);
                break;
            case 5 :
                intNumber = Integer.parseInt("1011011", 2);
                break;
            case 6 :
                intNumber = Integer.parseInt("1011111", 2);
                break;
            case 7 :
                intNumber = Integer.parseInt("1110000", 2);
                break;
            case 8 :
                intNumber = Integer.parseInt("1111111", 2);
                break;
            case 9 :
                intNumber = Integer.parseInt("1111011", 2);
                break;
            default:
                intNumber = 0;
        }

        return intNumber;
    }

    private static class Number {
        private final int number;
        private boolean dot;

        public Number(int number, boolean dot) {
            this.number = number;
            this.dot = dot;
        }
    }
}
