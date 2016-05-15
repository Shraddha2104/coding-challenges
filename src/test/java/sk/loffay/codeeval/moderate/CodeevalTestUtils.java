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
public abstract class CodeevalTestUtils {

    public static final String PATH = "src/test/java/sk/loffay/codeeval/moderate/";


    public static void testMain(String testFile, Consumer<String[]> main) throws FileNotFoundException {

        testFile = "codeeval/" + testFile;

        ClassLoader classLoader = CodeevalTestUtils.class.getClassLoader();
        File inputFile = new File(classLoader.getResource(testFile).getFile());

        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteOs);
        PrintStream oldSystemOut = System.out;
        System.setOut(ps);

        // invoke
        main.accept(new String[] {inputFile.getAbsolutePath()});

        String out = byteOs.toString();
        System.setOut(oldSystemOut);

        // expected result
        Scanner scanner = new Scanner(new File(inputFile + ".expected"));
        String expected = scanner.useDelimiter("\\A").next();
        scanner.close();

        Assert.assertEquals(expected, out);
    }


}
