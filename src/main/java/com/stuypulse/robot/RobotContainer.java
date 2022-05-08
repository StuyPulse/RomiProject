// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.stuypulse.robot;

import com.stuypulse.robot.commands.ExampleCommand;
import com.stuypulse.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * The RobotContainer class is where all of the robot's subsystems and autos are
 * defined and controller's button bindings are set
 */
public class RobotContainer {

    // The robot's subsystems and commands are defined here...
    private final Drivetrain drivetrain = new Drivetrain();
    // A way to choose which auto is going to run in the dashboard
    private static SendableChooser<Command> autoChooser = new SendableChooser<>(); 

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureButtonBindings();
        configureAutons();
    }

    private void configureButtonBindings() {} 

    private void configureAutons() {
        autoChooser.setDefaultOption("Example (Drive Forever)", new ExampleCommand(drivetrain));

        SmartDashboard.putData("Auto", autoChooser);
    }
        
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
