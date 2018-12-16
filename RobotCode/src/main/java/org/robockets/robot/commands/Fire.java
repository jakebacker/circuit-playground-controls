package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

public class Fire extends Command {

	public Fire() {
	}

	protected void initialize() {
		Robot.shooter.shoot();
		setTimeout(0.75);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.shooter.release();
	}

	protected void interrupted() {
		end();
	}
}