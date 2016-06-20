package sk.loffay.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class GPSBasedElevationCalculatorTest {

    @Test
    public void testZeroElevation() {
        List<GPSBasedElevationCalculator.GPSPoint> gpsPoints = generateWhiteNoisePoints(50, 3);

        GPSBasedElevationCalculator elevationCalculator = new GPSBasedElevationCalculator();

        for (GPSBasedElevationCalculator.GPSPoint point: gpsPoints) {
            elevationCalculator.process(point);
        }

        Assert.assertEquals(0, elevationCalculator.getElevation());
    }

    @Test
    public void testPositiveElevation() {
        GPSBasedElevationCalculator elevationCalculator = new GPSBasedElevationCalculator();
        final int error = 4;

        List<GPSBasedElevationCalculator.GPSPoint> gpsPoints = Arrays.asList(
                new GPSBasedElevationCalculator.GPSPoint(100, error),
                new GPSBasedElevationCalculator.GPSPoint(103, error),
                new GPSBasedElevationCalculator.GPSPoint(106, error),
                new GPSBasedElevationCalculator.GPSPoint(108, error),
                new GPSBasedElevationCalculator.GPSPoint(109, error),
                new GPSBasedElevationCalculator.GPSPoint(112, error),
                new GPSBasedElevationCalculator.GPSPoint(117, error)
        );

        for (GPSBasedElevationCalculator.GPSPoint point: gpsPoints) {
            elevationCalculator.process(point);
        }

        Assert.assertEquals(17, elevationCalculator.getElevation());

        elevationCalculator.process(new GPSBasedElevationCalculator.GPSPoint(110, error));
        elevationCalculator.process(new GPSBasedElevationCalculator.GPSPoint(113, error));
        elevationCalculator.process(new GPSBasedElevationCalculator.GPSPoint(110, error));

        Assert.assertEquals(17, elevationCalculator.getElevation());

    }

    public List<GPSBasedElevationCalculator.GPSPoint> generateWhiteNoisePoints(int number, int error) {
        Random random = new Random();
        List<GPSBasedElevationCalculator.GPSPoint> points = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            points.add(new GPSBasedElevationCalculator.GPSPoint(random.nextInt(error), error));
        }

        return points;
    }
}
