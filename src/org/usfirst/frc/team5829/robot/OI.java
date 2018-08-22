/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5829.robot;

import org.usfirst.frc.team5829.robot.commands.ArmMove;
import org.usfirst.frc.team5829.robot.commands.ArmSetMove;
import org.usfirst.frc.team5829.robot.commands.IntakeCube;
import org.usfirst.frc.team5829.robot.commands.Hang;

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
	Button btnA = new JoystickButton(xbox, 1); // A button
	Button btnB = new JoystickButton(xbox, 2); // B button
	Button btnX = new JoystickButton(xbox, 3); // X button
	Button btnY = new JoystickButton(xbox, 4); // Y button
	Button btnL1 = new JoystickButton(xbox, 5); // Left Bumper?
	Button btnR1 = new JoystickButton(xbox, 6); // Right Bumper?
	Button btnM = new JoystickButton(xbox, 7); // what is this
	Button btnS = new JoystickButton(xbox, 8); // what is this
	Button btnW = new JoystickButton(xbox, 9); // what is this
	
	//Controller 2
	Button btnA2 = new JoystickButton(xbox2, 1); // A button
	Button btnB2 = new JoystickButton(xbox2, 2); // B button
	Button btnX2 = new JoystickButton(xbox2, 3); // X button
	Button btnY2 = new JoystickButton(xbox2, 4); // Y button
	Button btnL2 = new JoystickButton(xbox2, 5); // Left Bumper?
	Button btnR2 = new JoystickButton(xbox2, 6); // Right Bumper?
	Button btnM2 = new JoystickButton(xbox2, 7); // what is this
	Button btnS2 = new JoystickButton(xbox2, 8); // what is this
	Button btnW2 = new JoystickButton(xbox2, 9); // what is this
	
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
		
		//first controller
		
		//Move Arm
		btnL1.whenPressed(new ArmMove(1, 0));
		btnL1.whenReleased(new ArmMove(0, 0));
		
		btnR1.whenPressed(new ArmMove(-1, 0));
		btnR1.whenReleased(new ArmMove(0, 0));
		
		btnB.toggleWhenPressed(new ArmMove(0, 1));//Move Intake
		btnY.toggleWhenPressed(new IntakeCube(1));//Move Intake Arms
		

		//Second Controller
		
		//Move Arm
		btnX2.whenPressed(new ArmSetMove(11895));//Switch
		btnY2.whenPressed(new ArmSetMove(41895));//Scale Level
		btnB2.whenPressed(new ArmSetMove(51270));//Max Height
		btnA2.whenPressed(new ArmSetMove(100));//Set to zero
		
		//btnL2.toggleWhenPressed(new ArmMove(0, 1));//Move Intake
		//btnR2.toggleWhenPressed(new IntakeCube(1));//Move Intake Arms

        // if this doesnt work try changing to toggleWhenPressed
        btnL2.whenPressed(new Hang(true)); // run winch
        btnL2.whenReleased(new Hang(false)): // stop winch
	}
}
