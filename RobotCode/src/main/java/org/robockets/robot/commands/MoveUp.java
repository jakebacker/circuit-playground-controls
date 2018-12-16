package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

public class MoveUp extends Command {

	public MoveUp() {
	}

	protected void initialize() {
		Robot.shooter.heightUp();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}