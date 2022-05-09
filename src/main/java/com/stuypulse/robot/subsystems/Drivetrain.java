package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.Constants.Drivetrain.Encoders;
import com.stuypulse.robot.Constants.Drivetrain.Ports;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    // Motors
    private final Spark leftMotor;
    private final Spark rightMotor;

    // Encoders
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;

    // The DifferentialDrive controller is a class that gives us the arcadeDrive
    // and tankDrive methods and controls the two motors that we give it
    private final DifferentialDrive drivetrain;

    public Drivetrain() {
        // Create motors using the ports from Constants.java
        leftMotor = new Spark(Ports.LEFT_MOTOR);
        rightMotor = new Spark(Ports.RIGHT_MOTOR);

        // Invert right side since motor is flipped
        rightMotor.setInverted(true);

        // Create differential drive
        drivetrain = new DifferentialDrive(leftMotor, rightMotor);

        // Create the encoders
        leftEncoder = new Encoder(Ports.LEFT_ENCODER_A, Ports.LEFT_ENCODER_B);
        rightEncoder = new Encoder(Ports.RIGHT_ENCODER_A, Ports.RIGHT_ENCODER_B);

        // Set the distance needed for the encoder to count one unit of distance
        // See Constants.java for an explanation of the unit conversions
        leftEncoder.setDistancePerPulse(Encoders.DISTANCE_PER_PULSE);
        rightEncoder.setDistancePerPulse(Encoders.DISTANCE_PER_PULSE);

        resetEncoders();
    }

    /*********************
     * ENCODER FUNCTIONS *
     *********************/

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    // returns distance that the left encoder has driven in meters
    public double getLeftDistance() {
        return leftEncoder.getDistance();
    }

    // returns distance that the right encoder has driven in meters
    public double getRightDistance() {
        return rightEncoder.getDistance();
    }

    /*********************
     * DRIVING FUNCTIONS *
     *********************/

    /**
     * tankDrive takes in two doubles, leftSpeed and rightSpeed, ranging from -1 to 1 that control
     * the two sides (wheels) of the drivetrain.
     *
     * For example:
     * tankDrive(1, 1) will drive straight forward
     * tankDrive(-1, -1) will drive backward
     * tankDrive(1, -1) will spin clockwise in place
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drivetrain.tankDrive(leftSpeed, rightSpeed, false);
    }

    /**
     * arcadeDrive takes in two doubles, xaxisSpeed and zaxisRotate, ranging from -1 to 1.
     * xaxisSpeed controls the forward/backward speed of the robot, and zaxisRotate controls the
     * rotation of the robot.
     *
     * For example:
     * arcadeDrive(1, 0) will drive straight forward
     * arcadeDrive(-1, 0) will drive backward
     * arcadeDrive(1, 1) will spin clockwise in place
     * arcadeDrive(1, 0.5) will drive forward and to the right
     */
    public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
        drivetrain.arcadeDrive(xaxisSpeed, zaxisRotate);
    }

    public void stop() {
        drivetrain.stopMotor();
    }

    /**********************
     * PERIODIC FUNCTIONS *
     **********************/

    @Override
    public void periodic() {}
}
