package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import org.avhsd.robolopes2339.frc2102.noob.RobotMap;
import org.avhsd.robolopes2339.frc2102.noob.commands.CollectBalls;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eric G. Miller
 */
public class BallCollectorSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private static BallCollectorSystem instance = null;
    private static final MotorDrive motorDrive = new MotorDrive(RobotMap.conveyorMotor);
    static {
    	motorDrive.setSafetyEnabled(false);
    }
    private double collectSpeed = 0.5;
    private double ejectSpeed = -0.5;

    public enum BallCollectState {
    	Stop,
    	Collect,
    	Eject;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CollectBalls());
    }

    public BallCollectorSystem(){
    }

    public static BallCollectorSystem getInstance() {
        if (instance == null)
            instance = new BallCollectorSystem();
        return instance;
    }

    /*
     * Move robot
     * 
     * @param ballCollect Set state of ball collector.
     * 
     */
    public void setBallCollector(BallCollectState ballCollect){
        System.out.println("BallCollectorSystem setBallCollector");
        switch (ballCollect) {
        case Stop:
        	motorDrive.set(0);
        	break;
        case Collect:
        	motorDrive.set(collectSpeed);
        	break;
        case Eject:
        	motorDrive.set(ejectSpeed);
        	break;
        }
    }

}