package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.parsing.IUtility;

/**
 * Safely control one or more motors.
 * Motors are run in-sync, that is they are always set to the same speed.
 * 
 * @author Eric G. Miller
 */
public class MotorDrive implements MotorSafety, IUtility {

    protected MotorSafetyHelper safetyHelper;
    private final static boolean EnableSafety = false;
    public static final double DefaultExpirationTime = 0.1;
    
	private List<SpeedController> speedControllers = new ArrayList<SpeedController>();
	
    /*
     * Set up motor safety
     */
    private void setupMotorSafety() {
        safetyHelper = new MotorSafetyHelper(this);
        safetyHelper.setExpiration(DefaultExpirationTime);
        safetyHelper.setSafetyEnabled(EnableSafety);
    }
    /*
     * Initialize with no motors. Use addMotor to add motors.
     */
    public MotorDrive(){
        setupMotorSafety();
    }

    /*
     * Initialize with one motor. Use addMotor to add motors.
     */
    public MotorDrive(int motorChannel){
    	addMotor(motorChannel);
        setupMotorSafety();
    }

    /*
     * Initialize with two motors. Use addMotor to add motors.
     */
    public MotorDrive(int motorChannel1, int motorChannel2){
    	addMotor(motorChannel1);
    	addMotor(motorChannel2);
        setupMotorSafety();
    }
    
    public void addMotor(int motorChannel) {
    	speedControllers.add(new Victor(motorChannel));
    }

	@Override
	public void setExpiration(double timeout) {
        safetyHelper.setExpiration(timeout);
	}

	@Override
	public double getExpiration() {
        return safetyHelper.getExpiration();
	}

	@Override
	public boolean isAlive() {
        return safetyHelper.isAlive();
	}
	
    /**
     * Limit motor values to the -1.0 to +1.0 range.
     */
    protected static double limit(double num) {
        if (num > 1.0) {
            return 1.0;
        }
        if (num < -1.0) {
            return -1.0;
        }
        return num;
    }

	public void set(double speed) {
		double limitedSpeed = limit(speed);
		for (SpeedController sc : speedControllers) {
			sc.set(limitedSpeed);
		}
		
        if (safetyHelper != null) {
        	safetyHelper.feed();
        }
	}

	@Override
	public void stopMotor() {
		set(0.0);
	}

	@Override
	public void setSafetyEnabled(boolean enabled) {
		safetyHelper.setSafetyEnabled(enabled);
		
	}

	@Override
	public boolean isSafetyEnabled() {
        return safetyHelper.isSafetyEnabled();
	}

	@Override
	public String getDescription() {
        return "Victor Drive";
	}

}