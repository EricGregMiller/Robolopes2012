/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avhsd.robolopes2339.frc2102.noob.commands;

/**
 *
 * @author Eric G. Miller
 */
public class DriveWithJoystick extends CommandBase {

    //DriveTrain m_drive;

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(CommandBase.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //drive.driveWithJoy(oi.getleftstickX(),oi.getleftstickY(),oi.getleftstickTwist(),0);
    	CommandBase.driveSystem.driveWithJoy(CommandBase.oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}