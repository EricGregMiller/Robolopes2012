package org.avhsd.robolopes2339.frc2102.noob.subsystems;

import org.avhsd.robolopes2339.frc2102.noob.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CoolingFanSystem extends Subsystem {

    private static CoolingFanSystem instance = null;
    private final Relay fanSpike = new Relay(RobotMap.coolingFan);
    
    public void initDefaultCommand() {
    }

    public static CoolingFanSystem getInstance() {
        if (instance == null)
            instance = new CoolingFanSystem();
        return instance;
    }
    
    public void startFan() {
    	fanSpike.set(Relay.Value.kOn);
    }
    
    
    public void stopFan() {
    	fanSpike.set(Relay.Value.kOn);
    }
    
    
    

}
