package com.stuypulse.robot;

import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.keyboard.SimKeyGamepad;

import com.stuypulse.robot.commands.DriveForever;
import com.stuypulse.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * The RobotContainer class is where all of the robot's subsystems and autos are defined and
 * controller's button bindings are set
 */
public class RobotContainer {

    // Creates a gamepad, which takes input from a controller or keyboard to control the robot
    private final Gamepad driver = new SimKeyGamepad();

    // The robot's subsystems and commands are defined here...
    private final Drivetrain drivetrain = new Drivetrain();
    // A way to choose which auto is going to run through the dashboard
    private static SendableChooser<Command> autoChooser = new SendableChooser<>();

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureAutons();
        configureButtonBindings();
        configureDefaultCommands();
    }

    /**
     * This method configures default commands for each of the subsystems using
     * subsystem.setDefaultCommand(command). This automatically runs the given command whenever
     * no other commands that require the subsystem are running.
     */
    private void configureDefaultCommands() {}

    private void configureButtonBindings() {}

    private void configureAutons() {
        autoChooser.setDefaultOption("Example (Drive Forever)", new DriveForever(drivetrain));

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
