/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5829.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	// Motors
	public static int leftBackMotor = 0;
	public static int leftFrontMotor = 1;
	public static int rightBackMotor = 2;
	public static int rightFrontMotor = 3;
	public static int leftArm = 4;
	public static int rightArm = 5;
	public static int intakeLeft = 6;
	public static int intakeRight = 7;
	
	// Solenoids
	public static int arm_up = 0;
	public static int arm_down = 1;
	public static int IntakeOpen = 2;
	public static int IntakeClose = 3;
}
