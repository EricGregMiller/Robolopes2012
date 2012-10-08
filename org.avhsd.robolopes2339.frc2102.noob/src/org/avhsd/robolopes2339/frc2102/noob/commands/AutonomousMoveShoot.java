/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avhsd.robolopes2339.frc2102.noob.commands;

import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallCollectorSystem.BallCollectState;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallShooterSystem.BallShootingState;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Move forward in autonomous mode.
 * 
 * @author Eric G. Miller
 */
public class AutonomousMoveShoot extends CommandBase {

    public final static double FORWARD_SPEED = 0.5;
    public final static double MOVE_TIME = 2.0; 
    public final static double SHOOT_TIME = 4.0;

    public AutonomousMoveShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(CommandBase.driveSystem);
        requires(CommandBase.ballCollectorSystem);
        requires(CommandBase.ballShooterSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation ds = DriverStation.getInstance();
    	if (ds.getMatchTime() < MOVE_TIME) {
    		CommandBase.driveSystem.moveRobot(0, FORWARD_SPEED, 0);
	    	CommandBase.ballCollectorSystem.setBallCollector(BallCollectState.Stop);
	    	CommandBase.ballShooterSystem.setShooter(BallShootingState.Stop);
    	} else if (ds.getMatchTime() > MOVE_TIME && ds.getMatchTime() < MOVE_TIME + SHOOT_TIME) {
    		CommandBase.driveSystem.moveRobot(0, 0, 0);
	    	CommandBase.ballCollectorSystem.setBallCollector(BallCollectState.Collect);
	    	CommandBase.ballShooterSystem.setShooter(BallShootingState.Long);
    	} else {
    		CommandBase.driveSystem.moveRobot(0, 0, 0);
	    	CommandBase.ballCollectorSystem.setBallCollector(BallCollectState.Stop);
	    	CommandBase.ballShooterSystem.setShooter(BallShootingState.Stop);
    	}
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