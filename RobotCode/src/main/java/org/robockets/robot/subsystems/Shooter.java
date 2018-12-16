package org.robockets.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.robot.RobotMap;

public class Shooter extends Subsystem {


	public void initDefaultCommand() {
	}

	public void setSpinnerSpeed(double speed){
		RobotMap.shooterFront.set(speed);
		RobotMap.shooterBack.set(speed);
	}

	public void shoot() {
		RobotMap.shooterPusher.set(DoubleSolenoid.Value.kReverse);
	}

	public void release() {
		RobotMap.shooterPusher.set(DoubleSolenoid.Value.kForward);
	}

	public void heightUp() {
		RobotMap.heightSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void heightDown() {
		RobotMap.heightSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

}
