package sk.loffay.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class NumberOfInversionsTest {

    private List<Integer> numbers;

    @Before
    public void beforeClass() throws URISyntaxException, IOException {
        URL url = NumberOfInversions.class.getClassLoader().getResource("coursera/numberOfInversions");
        File file = new File(url.toURI());
        numbers = loadNumbers(file.getAbsolutePath());
    }

    @Test
    public void testSmallSample() {
        List<Integer> sample = Arrays.asList(1, 3, 5, 2, 4, 6);
        long inversions = NumberOfInversions.numberOfInversions(sample);
    }

    @Test
    public void testCoursera() {
        Assert.assertEquals(100000, numbers.size());
        Assert.assertEquals(2407905288l, NumberOfInversions.numberOfInversions(numbers));
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
