package com.stuypulse.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This is the base robot class that includes special methods that will run at certain set times.
 */
public class Robot extends TimedRobot {

    private Command auto;
    private RobotContainer robot;

    @Override
    public void robotInit() {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        robot = new RobotContainer();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * This runs after the mode specific periodic functions, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**********************
     *** DISABLED ROBOT ***
     **********************/

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    /************************
     *** AUTONOMOUS ROBOT ***
     ************************/

    @Override
    public void autonomousInit() {
        // Gets the selected autonomous command from the dashboard
        auto = robot.getAutonomousCommand();

        // schedule the autonomous command
        if (auto != null) {
            auto.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {}

    /********************
     *** TELEOP ROBOT ***
     ********************/

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running.
        if (auto != null) {
            auto.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {}

    /******************
     *** TEST ROBOT ***
     ******************/

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {}
}
