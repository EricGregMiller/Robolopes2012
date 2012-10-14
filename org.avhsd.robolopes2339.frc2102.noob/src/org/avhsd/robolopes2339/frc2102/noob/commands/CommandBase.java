package org.avhsd.robolopes2339.frc2102.noob.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.avhsd.robolopes2339.frc2102.noob.OI;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallCollectorSystem;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallShooterSystem;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.CoolingFanSystem;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.DriveSystem;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.RampLeverSystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static CoolingFanSystem coolingFanSystem = new CoolingFanSystem();
    public static DriveSystem driveSystem = new DriveSystem();
    public static BallCollectorSystem ballCollectorSystem = new BallCollectorSystem();
    public static BallShooterSystem ballShooterSystem = new BallShooterSystem();
    public static RampLeverSystem rampLeverSystem = new RampLeverSystem();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(coolingFanSystem);
        SmartDashboard.putData(driveSystem);
        SmartDashboard.putData(ballCollectorSystem);
        SmartDashboard.putData(ballShooterSystem);
        SmartDashboard.putData(rampLeverSystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
