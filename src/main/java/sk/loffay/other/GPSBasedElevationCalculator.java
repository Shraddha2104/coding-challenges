package sk.loffay.other;

/**
 *
 * Write a function that calculates total elevation. Points contain altitude and error radius.
 *
 * Altitude - vyska
 * Longitude - dlzka
 * Latitude - sirka
 *
 * Elevation - stupanie
 *
 * diameter - priemer
 * radius - polomer
 *
 * @author Pavol Loffay
 */
public class GPSBasedElevationCalculator {

    private int elevation;

    private GPSPoint previousPoint;

    /**
     * @return true if process changed
     */
    public void process(GPSPoint currentPoint) {
        if (previousPoint == null) {
            previousPoint = currentPoint;
            return;
        }

        int diff = currentPoint.altitude - previousPoint.altitude;

        // skip because difference is not higher than error
        if (Math.abs(diff) > currentPoint.error) {
            //nothing
            if (diff > 0) {
                elevation += diff;
            }

            previousPoint = currentPoint;
        }
    }

    public int getElevation() {
        return elevation;
    }

    public static class GPSPoint {
        private int altitude;
        private int error;

        public GPSPoint(int altitude, int error) {
            this.altitude = altitude;
            this.error = error;
        }
    }
}
