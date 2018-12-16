import com.fazecast.jSerialComm.SerialPort;
import redlaboratory.jvjoyinterface.VJoy;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		VJoy joy = new VJoy();
		int rID = 1;
		System.out.println(joy.acquireVJD(rID));

		if (!joy.vJoyEnabled()) {
			System.out.println("Error! VJoy not enabled!");

			System.exit(1);
		}

		if (!joy.driverMatch()) {
			System.out.println("Error! VJoy driver not compatable");

			System.exit(1);
		}

		SerialPort comPort = SerialPort.getCommPorts()[0]; // This should work fine
		comPort.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
		comPort.openPort();

		comPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);
		try {
			while (true) {
				while (comPort.bytesAvailable() <= 0) {
					Thread.sleep(20);
				}

				byte[] readBuffer = new byte[comPort.bytesAvailable()];
				int numRead = comPort.readBytes(readBuffer, readBuffer.length);

				/*System.out.println("Read " + numRead + " bytes.");
				String s = new String(readBuffer);
				System.out.println(s);*/

				String pair = new String(readBuffer); // Convert bytes to string

				String[] pairArr = pair.split(":");

				if (pairArr.length == 1) {
					continue; // Skip it
				}

				String command = pairArr[0].trim();

				double value;
				try {
					value = Double.parseDouble(pairArr[1].trim());
				} catch (NumberFormatException ee) {
					continue;
				}

				System.out.println(pair);

				switch (command) {
					case "forward":
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE * (1 + value)), rID, VJoy.HID_USAGE_Y);
						joy.setAxis(VJoy.AXIS_MID_VALUE, rID, VJoy.HID_USAGE_X);
						break;
					case "backward":
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE * (1 - value)), rID, VJoy.HID_USAGE_Y);
						joy.setAxis(VJoy.AXIS_MID_VALUE, rID, VJoy.HID_USAGE_X);
						break;
					case "left":
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE * (1 - value)), rID, VJoy.HID_USAGE_X);
						joy.setAxis(VJoy.AXIS_MID_VALUE, rID, VJoy.HID_USAGE_Y);
						break;
					case "right":
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE * (1 + value)), rID, VJoy.HID_USAGE_X);
						joy.setAxis(VJoy.AXIS_MID_VALUE, rID, VJoy.HID_USAGE_Y);
						break;
					case "up":
						joy.setBtn(true, rID, 1);
						Thread.sleep(50);
						break;
					case "down":
						joy.setBtn(true, rID, 4);
						Thread.sleep(50);
						break;
					case "stop":
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE), rID, VJoy.HID_USAGE_Y);
						joy.setAxis((long) (VJoy.AXIS_MID_VALUE), rID, VJoy.HID_USAGE_X);
						break;
				}

				joy.resetButtons(rID);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		comPort.closePort();
	}
}
