package org.avhsd.robolopes2339.frc2102.noob;

import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallCollectorSystem.BallCollectState;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.BallShooterSystem.BallShootingState;
import org.avhsd.robolopes2339.frc2102.noob.subsystems.RampLeverSystem.RampLeverState;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
 * Process operator input
 */
public class OI {
	private Joystick joystick = new Joystick(RobotMap.joystickPort);
	private Button shoot = new JoystickButton(joystick, RobotMap.buttonShoot), 
				   ballCollect = new JoystickButton(joystick, RobotMap.buttonBallCollect), 
				   ballEject = new JoystickButton(joystick, RobotMap.buttonBallEject), 
				   rampLeverDown = new JoystickButton(joystick, RobotMap.buttonRampLeverDown), 
				   rampLeverUp = new JoystickButton(joystick, RobotMap.buttonRampLeverUp);
	
	public Joystick getJoystick() {
		return joystick;
	}
	
	public boolean getShoot() {
		return shoot.get();
	}
	
	public BallCollectState getBallCollect() {
		if (ballCollect.get()) {
			return BallCollectState.Collect;
		} else if (ballEject.get()) {
			return BallCollectState.Eject;
		}
		return BallCollectState.Stop;
	}
	
	public BallShootingState getBallShoot() {
		if (shoot.get()) {
			return BallShootingState.Long;
		}
		return BallShootingState.Stop;
	}
	
	public RampLeverState getRampLever() {
		if (rampLeverDown.get()) {
			return RampLeverState.MoveDown;
		} else if (rampLeverUp.get()) {
			return RampLeverState.MoveUp;
		}
		return RampLeverState.Stop;
	}
}

