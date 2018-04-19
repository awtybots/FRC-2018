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
	public static int leftBackMotor = 9;
	public static int leftMiddleMotor = 4;
	public static int leftFrontMotor = 5;

	public static int rightBackMotor = 3;
	public static int rightMiddleMotor = 7;
	public static int rightFrontMotor = 10;

	public static int liftMotor1 = 3;
	public static int liftMotor2 = 4;
	public static int liftMotor3 = 5;
	public static int liftMotor4 = 6;
	
	public static int intakeLeft = 2;
	public static int intakeRight = 1;
	public static int intakeLift = 0;
	
	
	// Solenoids
	public static int arm_up = 2;
	public static int arm_down = 3;
	
	public static int IntakeOpen = 4;
	public static int IntakeClose = 5;
	
//	public static int breakOpen = 2;
//	public static int breakClose = 3;
	
	
	// Sensors
	public static int limit = 8;
	public static int bumper = 9;
	
	//I2C
	public static final int i2cLidarAddress = 0x62;
}