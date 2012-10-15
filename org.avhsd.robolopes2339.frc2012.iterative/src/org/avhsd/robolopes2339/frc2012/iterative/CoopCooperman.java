/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.avhsd.robolopes2339.frc2012.iterative;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class CoopCooperman extends IterativeRobot {
    Joystick driveStick = new Joystick(1);
    
    Jaguar m_frontLeft = new Jaguar(1);
    Jaguar m_frontRight= new Jaguar(2);
    Jaguar m_rearLeft  = new Jaguar(3);
    Jaguar m_rearRight = new Jaguar(4);
    
    RobotDrive mecanum = 
            new RobotDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);
    
    
    Victor intake = new Victor(6);
    
    Victor shooterA = new Victor(7);
    Victor shooterB = new Victor(8);
    
    Relay fan = new Relay(1);
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("Done initializing!");
    }
    long startTime = 0;
    public void autonomousInit() {
        startTime = System.currentTimeMillis();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        long elapsed = System.currentTimeMillis() - startTime;
        if(elapsed > 0 && elapsed < 2500) {
            mecanumDrive(0, -.3, 0);
        } else {
            mecanumDrive(0, 0, 0);
            setShooterMotors(1.0);
            intake.set(1.0);
        }
        
    }
    
    public void teleopInit() {
        fan.set(Relay.Value.kForward);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        System.out.println("Running teleop!");
        fan.set(Relay.Value.kForward);
        double strafe = driveStick.getRawAxis(1),
               throttle = driveStick.getRawAxis(2),
               rotation = driveStick.getRawAxis(4);
        if(Math.abs(strafe) > .75) {
            strafe *= .6;
        }
        
        mecanumDrive(strafe, throttle, rotation);
//        if(driveStick.getRawButton(2)) {
//            m_frontRight.set(throttle);
//        } else if(driveStick.getRawButton(3)){
//            m_rearLeft.set(throttle);
//        } else if(driveStick.getRawButton(4)){
//            m_rearRight.set(throttle);
//        }
        
        if(driveStick.getRawButton(3)) {
            intake.set(1.0);
        } else if(driveStick.getRawButton(4)) {
            intake.set(-1.0);
        } else {
            intake.set(0.0);
        }
        
        if(driveStick.getRawButton(1)) {
            setShooterMotors(1.0);
        } else {
            setShooterMotors(0.0);
        }
    }
    
    public void setShooterMotors(double value) {
        shooterA.set(value);
        shooterB.set(value);
    }
    
    public void mecanumDrive(double x, double y, double rot) {
        double fL = 0, fR = 0, rL = 0, rR = 0;
        y *= -1.0;
        
        fL = x + y + rot;
        fR = -x + y - rot;
        rL = -x + y + rot;
        rR = x + y - rot;
        
        m_frontLeft.set(fL);
        m_frontRight.set(-fR);
        m_rearLeft.set(rL);
        m_rearRight.set(-rR);
    }
}
