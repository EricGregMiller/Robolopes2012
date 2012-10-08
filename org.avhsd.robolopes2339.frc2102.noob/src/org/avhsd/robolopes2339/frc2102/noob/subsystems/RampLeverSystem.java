package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import org.avhsd.robolopes2339.frc2102.noob.RobotMap;
import org.avhsd.robolopes2339.frc2102.noob.commands.MoveRampLever;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eric G. Miller
 */
public class RampLeverSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private static RampLeverSystem instance = null;
    private static final MotorDrive motorDrive = new MotorDrive(RobotMap.rampLeverMotor);
    static {
    	motorDrive.setSafetyEnabled(false);
    }
    private double downSpeed = 0.5;
    private double upSpeed = -0.5;

	public enum RampLeverState {
		Stop,
		MoveDown,
		MoveUp;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new MoveRampLever());
    }

    public RampLeverSystem(){
    }

    public static RampLeverSystem getInstance() {
        if (instance == null)
            instance = new RampLeverSystem();
        return instance;
    }

    /*
     * Move robot
     * 
     * @param ballCollect Set state of ball collector.
     * 
     */
    public void setRampLever(RampLeverState rampLever){
        System.out.println("RampLeverSystem setRampLever");
        switch (rampLever) {
        case Stop:
        	motorDrive.set(0);
        	break;
        case MoveDown:
        	motorDrive.set(downSpeed);
        	break;
        case MoveUp:
        	motorDrive.set(upSpeed);
        	break;
        }
    }

}