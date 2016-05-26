package sk.loffay.netsute;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author Pavol Loffay
 */
public class StreamProbability {

    /**
     * Method should return random byte from input stream. (uniform distribution)
     *
     * @param is
     * @return random byte
     * @throws IOException
     */
    public static byte getRandom(InputStream is) throws IOException {

        int input = 0;
        byte result = 0;
        int size = 0;

        Random random = new Random();

        while ((input = is.read()) > 0) {
            if (random.nextDouble() < 1.0/++size) {
                result = (byte)input;
            }
        }

        return result;
    }
}
