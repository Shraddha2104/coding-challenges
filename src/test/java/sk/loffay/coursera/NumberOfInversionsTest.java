package sk.loffay.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class NumberOfInversionsTest {

    private static List<Integer> numbers;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException, IOException {
        URL url = NumberOfInversions.class.getClassLoader().getResource("coursera/numberOfInversions");
        File file = new File(url.toURI());
        numbers = loadNumbers(file.getAbsolutePath());
    }

    @Test
    public void test() {
        Assert.assertEquals(100000, numbers.size());

        System.out.println("Number of inversions: " + NumberOfInversions.numberOfInversions(numbers));
    }

    private static List<Integer> loadNumbers(String filename) throws IOException, URISyntaxException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line;
        List<Integer> numbers = new ArrayList<>(100000);
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            Integer number = Integer.parseInt(line);
            numbers.add(number);
        }

        return numbers;
    }
}
