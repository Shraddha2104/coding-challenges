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
public class Locks {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(" ");

            int doors = Integer.parseInt(split[0].trim());
            int iterations = Integer.parseInt(split[1].trim());

            System.out.println(numberOfOpenDoors(doors, iterations));
        }
    }

    public static int numberOfOpenDoors(int doors, int iterations) {
        List<Boolean> closedDoors = new ArrayList<>(doors);
        for (int i = 0; i <  doors; i++) {
            closedDoors.add(new Boolean(false));
        }

        while (iterations > 0) {

            // close the last
            if (iterations == 1) {
                Boolean state = closedDoors.get(closedDoors.size() - 1);
                closedDoors.set(closedDoors.size() -1, !state);
            } else {
                for (int i = 0; i < closedDoors.size(); i++) {
                    if (i%2 == 1) {
                        closedDoors.set(i, true);
                    }

                    if (i%3 == 2) {
                        closedDoors.set(i, !closedDoors.get(i));
                    }
                }
            }

            iterations--;
        }

        int openDoors = 0;
        for (Boolean closed: closedDoors) {
            if (!closed) {
                openDoors++;
            }
        }
        return openDoors;
    }
}
