// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.Constants.Drivetrain.Ports;
import com.stuypulse.robot.Constants.Drivetrain.Encoders;

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

        // Set the distance needed for the encoder to count a unit of distance
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

    public double getLeftDistanceInch() {
        return leftEncoder.getDistance();
    }

    public double getRightDistanceInch() {
        return rightEncoder.getDistance();
    }
    
    /*********************
     * DRIVING FUNCTIONS *
     *********************/
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drivetrain.tankDrive(leftSpeed, rightSpeed, false);
    }

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
