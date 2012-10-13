package org.avhsd.robolopes2339.frc2102.noob;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/*
     * For example to map the left and right motors, you could define the
     * following variables to use with your drivetrain subsystem.
     * public static final int leftMotor = 1;
     * public static final int rightMotor = 2;
    
     * If you are using multiple modules, make sure to define both the port
     * number and the module. For example you with a rangefinder:
     * public static final int rangefinderPort = 1;
     * public static final int rangefinderModule = 1;
    */

	/*
	 * map for digital sidecar pwm channels 1 - 10 
	 */
    public static final int
            //RobotDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor)
            frontLeftMotor = 1,
            rearLeftMotor = 2,
            frontRightMotor = 3,
            rearRightMotor = 4,

            conveyorMotor = 6,
            rampLeverMotor = 5, 
            shootMotor1 = 7,
            shootMotor2 = 8; 

	/*
	 * map for digital sidecar I/O channels 1 - 14 
	 */
    public static final int
            coolingFan = 1;


	/*
	 * map for driver station ports 
	 */
    public static final int
            joystickPort = 1;

	/*
	 * map for joystick buttons 
	 */
    public static final int
            buttonShoot = 1,
            buttonBallCollect = 3,
            buttonBallEject = 6,
            buttonRampLeverDown = 4,
            buttonRampLeverUp = 5;


	/*
	 * map for analog module breakout channels 1 - 8 
	 */
    public static final int
            //The analog channel the gyro is connected to.
            gyrochan = 1;
}
