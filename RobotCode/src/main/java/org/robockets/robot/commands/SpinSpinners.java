package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

public class SpinSpinners extends Command {

	private double speed;

	public SpinSpinners(double speed) {
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.shooter.setSpinnerSpeed(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.shooter.setSpinnerSpeed(0);
	}

	protected void interrupted() {
		end();
	}
}