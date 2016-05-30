package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * this solution might not work, I think they have an error there..
 */
public class RoboAndRobitta {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            String[] split = line.split("\\|");
            int sizeX = Integer.parseInt(split[0].trim().split("x")[0]);
            int sizeY = Integer.parseInt(split[0].trim().split("x")[1]);
            int robittaX = Integer.parseInt(split[1].trim().split(" ")[0]);
            int robittaY = Integer.parseInt(split[1].trim().split(" ")[1]);

            int[][] field = new int[sizeX][sizeY];

            int nutsForRobitta = nutsForRobitta(field, robittaX, robittaY);
            System.out.println(nutsForRobitta);
        }
    }
    public static int nutsForRobittaIterative(int[][] field, int robittaX, int robittaY) {

        robittaX--;
        robittaY--;
        int nuts = 0;
        boolean found = false;

        return nuts;
    }

    public static int nutsForRobitta(int[][] field, int robittaX, int robittaY) {
        robittaX--;
        robittaY--;

        int[][] reducedField = reducedField(field, robittaX, robittaY);

        int count = nutsFromReducedField(field, reducedField);
        count += findRobitta(reducedField);

        return count;
    }

    private static int[][] reducedField(int[][] field, int robittaX, int robittaY) {

        int minX = Math.min(field.length -1 - robittaX, robittaX);
        int minY = Math.min(field[0].length -1 - robittaY, robittaY);

        int reducedCircuits = Math.min(minX, minY);

        int[][] reducedField = new int[field.length - 2*reducedCircuits][field[0].length - 2*reducedCircuits];
        reducedField[robittaX - reducedCircuits][robittaY - reducedCircuits] = -1;

        return reducedField;
    }

    private static int nutsFromReducedField(int[][] originalField, int[][] reducedField) {

        int reducedCircuits = (originalField.length - reducedField.length + 1)/2;

        int count = 0;
        int originalRowLength = originalField.length;
        int originalColLength = originalField[0].length;
        for (int i = 0; i < reducedCircuits; i++) {
            count += 2*originalRowLength + 2*originalColLength - 4;
            originalRowLength  -= 2;
            originalColLength -= 2;
        }

        return count;
    }

    private static int findRobitta(int[][] field) {

        int count = 0;
        //do row
        for (int i = 0; i < field[0].length; i++) {
            if (field[0][i] == -1) {
                return count;
            }
            count++;
        }
        count--;
        // go down
        for (int i = 0; i < field.length; i++) {
            if (field[i][field[0].length - 1] == -1) {
                return count;
            }
            count++;
        }
        count--;
        //go left
        for (int i = field[0].length - 1; i >= 0; i--) {
            if (field[field.length - 1][i] == -1) {
                return count;
            }
            count++;
        }
        count--;
        //go up
        for (int i = field.length - 1; i >= 0; i--) {
            if (field[i][0] == -1) {
                return count;
            }
            count++;
        }

        return count;
    }
}
