package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Pavol Loffay
 *
 * 100%
 */
public class CarRace {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        boolean trackInfo = true;
        RaceTrack raceTrack = new RaceTrack();
        List<Car> cars = new ArrayList<>(40);

        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            String[] split = line.split(" ");

            if (trackInfo) {
                Straight straight = null;
                Curve startCurve = new Curve(180);
                Curve endCurve = null;
                for (String number: split) {
                    if (number.contains(".")) {
                        double miles = Double.parseDouble(number);
                        straight = new Straight(miles);
                    } else {
                        int angle = Integer.parseInt(number);
                        endCurve = new Curve(angle);
                        raceTrack.addTrackSegment(new RaceTrackSegment(startCurve, straight, endCurve));
                        startCurve = endCurve;
                    }

                }
                trackInfo = false;
                continue;
            }

            int number = Integer.parseInt(split[0]);
            int topSpeed = Integer.parseInt(split[1]);
            double accelerate = Double.parseDouble(split[2]);
            double breakTime = Double.parseDouble(split[3]);

            Car car = new Car(number, topSpeed, accelerate, breakTime);
            cars.add(car);
        }

//         todo two same times?
        Map<Double, Car> carMap = new TreeMap<>();
        for (Car car: cars) {
            double time = raceTrack.calculateTime(car);
            carMap.put(time, car);
        }

        for (Map.Entry<Double, Car> entry: carMap.entrySet()) {
            Car car = entry.getValue();
            double time = entry.getKey();
            System.out.format("%d %.2f\n", car.number, time);
        }

    }

    private static class RaceTrack {

        private List<RaceTrackSegment> trackSegments = new LinkedList<>();

        public void addTrackSegment(RaceTrackSegment trackSegment) {
            trackSegments.add(trackSegment);
        }

        public double calculateTime(Car car) {

            double time = 0;
            for (RaceTrackSegment trackPart: trackSegments) {
                time += trackPart.calculateTime(car);
            }

            return time;
        }
    }

    private static class RaceTrackSegment {
        Curve startCurve;
        Straight straight;
        Curve endCurve;

        public RaceTrackSegment(Curve startCurve, Straight straight, Curve endCurve) {
            this.startCurve = startCurve;
            this.straight = straight;
            this.endCurve = endCurve;
        }

        double calculateTime(Car car) {

            double speedAtStartCurve = car.topSpeed - (startCurve.angle/180.0)*car.topSpeed;
            double speedAtEndCurve = car.topSpeed - (endCurve.angle/180.0)*car.topSpeed;

            // going up
            double tUp = (car.topSpeed - speedAtStartCurve)/car.accelerateUp;
            double sUp = speedAtStartCurve*tUp + 0.5*car.accelerateUp*tUp*tUp;
            // going down
            double tDown = (car.topSpeed - speedAtEndCurve)/car.accelerateDown;
            double sDown = car.topSpeed*tDown - 0.5*car.accelerateDown*tDown*tDown;
            //top
            double sTop = straight.miles - sUp - sDown;
            double tTop = sTop/car.topSpeed;

            return tUp + tTop + tDown;
        }
    }

    private static class Curve {
        private final double angle;

        public Curve(int angle) {
            this.angle = angle;
        }
    }

    private static class Straight {
        private final double miles;

        public Straight(double miles) {
            this.miles = miles;
        }
    }

    private static class Car {
        private final int number;
        private final double topSpeed;
        private final double accelerateTime;
        private final double breakTime;

        private final double accelerateUp;
        private final double accelerateDown;

        public Car(int number, int topSpeed, double accelerateTime, double breakTime) {
            this.number = number;
            this.topSpeed = topSpeed/60.0/60.0;
            this.accelerateTime = accelerateTime;
            this.breakTime = breakTime;

            this.accelerateUp = this.topSpeed/accelerateTime;
            this.accelerateDown = this.topSpeed/breakTime;
        }
    }
}
