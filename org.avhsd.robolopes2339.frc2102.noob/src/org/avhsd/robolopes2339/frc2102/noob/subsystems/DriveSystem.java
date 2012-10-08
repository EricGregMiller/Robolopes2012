package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import org.avhsd.robolopes2339.frc2102.noob.RobotMap;
import org.avhsd.robolopes2339.frc2102.noob.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Eric G. Miller
 */
public class DriveSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private RobotDrive robotDrive;
    private static DriveSystem instance = null;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    public DriveSystem(){
        robotDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor, RobotMap.frontRightMotor, RobotMap.rearRightMotor);
        robotDrive.setSafetyEnabled(false);
    }

    public static DriveSystem getInstance() {
        if (instance == null)
            instance = new DriveSystem();
        return instance;
    }

    /*
     * Move robot
     * 
     * @param xSpeed speed in x direction (-1 to 1, left-right)
     * @param ySpeed speed in y direction (-1 to 1, back-front)
     * @param rotateSpeed speed to rotate (-1 to 1)
     * 
     */
    public void moveRobot(double xSpeed, double ySpeed, double rotateSpeed){
        System.out.println("DriveSystem moveRobot");
        robotDrive.mecanumDrive_Cartesian(xSpeed, ySpeed, rotateSpeed, 0);
    }

    /*
     * Use joystick input to move robot.
     * 
     * @param driveStick Joystick used to control robot motion.
     */
    public void driveWithJoy(Joystick driveStick){
        System.out.println("DriveSystem driveWithJoy");
        moveRobot(driveStick.getX(), driveStick.getX(), driveStick.getTwist());
    }

}