package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import org.avhsd.robolopes2339.frc2102.noob.RobotMap;
import org.avhsd.robolopes2339.frc2102.noob.commands.ShootBall;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eric G. Miller
 */
public class BallShooterSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private static BallShooterSystem instance = null;
    private static final MotorDrive motorDrive = new MotorDrive(RobotMap.shootMotor1, RobotMap.shootMotor2);
    static {
    	motorDrive.setSafetyEnabled(false);
    }
    private double longSpeed = 1.0;
    private double mediumSpeed = 0.75;
    private double shortSpeed = 0.5;
    
    public enum BallShootingState {
	    	Stop,
	    	Long,
	    	Medium, 
	    	Short, 
	    	Automatic;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootBall());
    }

    public static BallShooterSystem getInstance() {
        if (instance == null)
            instance = new BallShooterSystem();
        return instance;
    }

    /*
     * Set state of ball shooter
     * 
     * @param ballShoot state to set.
     * 
     */
    public void setShooter(BallShootingState ballShoot){
        System.out.println("BallShootingSystem setShooter");
        
        switch (ballShoot) {
        case Stop:
        	motorDrive.set(0);
        	break;
        case Long:
        	motorDrive.set(longSpeed);
        	break;
        case Medium:
        	motorDrive.set(mediumSpeed);
        	break;
        case Short:
        	motorDrive.set(shortSpeed);
        	break;
        case Automatic:
        	motorDrive.set(longSpeed);
        	break;
        }
    }

}