package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.RobotMap;

public class ToggleCompressor extends Command {

	public ToggleCompressor() {
	}

	protected void initialize() {
		if (RobotMap.compressor.enabled()) {
			RobotMap.compressor.stop();
		} else {
			RobotMap.compressor.start();
		}

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