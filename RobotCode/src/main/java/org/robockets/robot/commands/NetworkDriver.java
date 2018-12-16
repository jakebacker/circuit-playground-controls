package org.robockets.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.OI;
import org.robockets.robot.Robot;

public class NetworkDriver extends Command {


	private final double SPEED_MULTIPLIER = 0.6;

	public NetworkDriver() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {

		double translate = OI.virtualStick.getRawAxis(1);
		double rotate = OI.virtualStick.getRawAxis(0); // Double check this one

		translate *= SPEED_MULTIPLIER;
		rotate *= (SPEED_MULTIPLIER+.25);

		Robot.drivetrain.driveArcade(translate, rotate);

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
		end();
	}
}