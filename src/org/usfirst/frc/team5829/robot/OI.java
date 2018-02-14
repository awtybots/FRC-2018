/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5829.robot;

import org.usfirst.frc.team5829.robot.commands.Arm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick xbox = new Joystick(0);
	public Joystick xbox2 = new Joystick(1);
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	//Controller 1
	Button btnA = new JoystickButton(xbox, 1);
	Button btnB = new JoystickButton(xbox, 2);
	Button btnX = new JoystickButton(xbox, 3);
	Button btnY = new JoystickButton(xbox, 4);
	Button btnL1 = new JoystickButton(xbox, 5);
	Button btnR1 = new JoystickButton(xbox, 6);
	Button btnM = new JoystickButton(xbox, 7);
	Button btnS = new JoystickButton(xbox, 8);
	Button btnW = new JoystickButton(xbox, 9);
	
	//Controller 2
	Button btnA2 = new JoystickButton(xbox2, 1);
	Button btnB2 = new JoystickButton(xbox2, 2);
	Button btnX2 = new JoystickButton(xbox2, 3);
	Button btnY2 = new JoystickButton(xbox2, 4);
	Button btnL12 = new JoystickButton(xbox2, 5);
	Button btnR12 = new JoystickButton(xbox2, 6);
	Button btnM2 = new JoystickButton(xbox2, 7);
	Button btnS2 = new JoystickButton(xbox2, 8);
	Button btnW2 = new JoystickButton(xbox2, 9);
	
	public double getRawAnalogStickALX() {
		return xbox.getRawAxis(0);
	}
	
	public double getRawAnalogStickALY() {
		return xbox.getRawAxis(1);
	}
	
	public double getRawAnalogStickARX() {
		return xbox.getRawAxis(4);
	}
	
	public double getRawAnalogStickARY() {
		return xbox.getRawAxis(5);
	}

	public double getRawLZ(){
		return xbox.getRawAxis(2);
	}
	public double getRawRZ(){
		return xbox.getRawAxis(3);
	}
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public OI() {
		
		btnL1.whenPressed(new Arm(1));
		btnL1.whenReleased(new Arm(0));
		
		btnR1.whenPressed(new Arm(-1));
		btnR1.whenReleased(new Arm(0));
		
	}
}
