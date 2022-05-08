// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An Example command that drives forwards forever
 */
public class ExampleCommand extends CommandBase {
    private final Drivetrain drivetrain;

    public ExampleCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        // This makes sure that if two commands both require the drivetrain,
        // they won't use them at the same time.
        addRequirements(drivetrain);
    }

    // Called once when the command starts
    @Override
    public void initialize() {}

    // Called 50 times a second if the command is running
    @Override
    public void execute() {
        // Drive with full speed forward and no turn
        drivetrain.arcadeDrive(1, 0);
    }

    // Called once when the command ends
    @Override
    public void end(boolean interrupted) {}

    // Tells the comman to stop (or keep on) running
    @Override
    public boolean isFinished() {
        return false;
    }
}
