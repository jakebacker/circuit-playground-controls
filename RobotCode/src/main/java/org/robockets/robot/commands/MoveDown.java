package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

public class MoveDown extends Command {

	public MoveDown() {
	}

	protected void initialize() {
		Robot.shooter.heightDown();
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