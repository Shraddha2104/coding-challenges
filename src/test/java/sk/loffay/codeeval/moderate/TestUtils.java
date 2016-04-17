package sk.loffay.codeeval.moderate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Consumer;

import org.junit.Assert;

/**
 * @author Pavol Loffay
 */
public abstract class TestUtils {

    public static final String PATH = "src/test/java/sk/loffay/codeeval/moderate/";


    public static void testMain(String testFile, Consumer<String[]> main) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH + testFile + ".expected"));
        String expected = scanner.useDelimiter("\\A").next();
        scanner.close();

        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteOs);
        PrintStream oldSystemOut = System.out;
        System.setOut(ps);

        // invoke
        main.accept(new String[] {PATH + testFile});

        String out = byteOs.toString();
        System.setOut(oldSystemOut);

        Assert.assertEquals(expected, out);
    }

}
