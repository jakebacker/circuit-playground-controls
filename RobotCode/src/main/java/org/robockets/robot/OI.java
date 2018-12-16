package org.robockets.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.robockets.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joystick = new Joystick(0);
	public static Joystick virtualStick = new Joystick(1);
	public static Button virtualAButton = new JoystickButton(virtualStick, 1);
	public static Button virtualYButton = new JoystickButton(virtualStick, 4);

	public static Button yButton = new JoystickButton(joystick, 4);
	public static JoystickButton selectButton = new JoystickButton(joystick, 7);
	public static JoystickButton startButton = new JoystickButton(joystick, 8);

	public static Button aButton = new JoystickButton(joystick, 1);
	public static Button bButton = new JoystickButton(joystick, 2);

	public static Button leftBumper = new JoystickButton(joystick, 5);
	public static Button rightBumper = new JoystickButton(joystick, 6);

	public OI() {
		aButton.whenPressed(new MoveUp());
		bButton.whenPressed(new MoveDown());

		virtualAButton.whenPressed(new MoveUp());
		virtualYButton.whenPressed(new MoveDown());

		leftBumper.whileHeld(new SpinSpinners(0.75));
		rightBumper.whenPressed(new Fire());

		selectButton.whenPressed(new NetworkDriver());
		startButton.whenPressed(new DriveGo());

		yButton.whenPressed(new ToggleCompressor());
	}
}
