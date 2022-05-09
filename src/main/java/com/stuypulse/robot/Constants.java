package com.stuypulse.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public interface Drivetrain {

        public interface Ports {
            int LEFT_MOTOR = 0;
            int RIGHT_MOTOR = 1;

            int LEFT_ENCODER_A = 4;
            int LEFT_ENCODER_B = 5;

            int RIGHT_ENCODER_A = 6;
            int RIGHT_ENCODER_B = 7;
        }

        public interface Encoders {
            double COUNTS_PER_REVOLUTION = 1440.0;
            double WHEEL_DIAMETER_METERS = 0.070; // 70 mm

            /**
             * The distance per pulse is the number of meters the robot has driven for ever pulse
             * that the encoders count.
             *
             * To find the distance per pulse, we divide the circumference of the circle by
             * COUNTS_PER_REVOLUTION so we know the distance that each count travels. Since
             * circumference = 2*pi*r and diameter = 2r, the circumference is pi*diameter. Last, we
             * can just divide by the counts per revolution.
             */
            double DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;
        }
    }
}
