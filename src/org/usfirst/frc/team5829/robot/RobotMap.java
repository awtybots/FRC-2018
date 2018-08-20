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
	public static int leftBackMotor = 10; // Talon
	public static int leftMiddleMotor = 6; // Talon
	public static int leftFrontMotor = 9; // Talon

	public static int rightBackMotor = 4; // Talon
	public static int rightMiddleMotor = 5; // Talon
	public static int rightFrontMotor = 14; // Talon

	public static int leftHangMotor = 11;
	public static int rightHangMotor = 12;
	
	public static int liftMotor1 = 7;
	public static int liftMotor2 = 2;
	public static int liftMotor3 = 3;
	public static int liftMotor4 = 1;
	
	public static int intake = 0;
	public static int intake2 = 8;
	
	
	// Solenoids
	public static int arm_up = 3;
	public static int arm_down = 2;
	
	public static int IntakeOpen = 6;
	public static int IntakeClose = 7;
	
	public static int breakOpen = 0;
	public static int breakClose = 1;
	
	
	// Sensors
	public static int limit = 8;
	public static int bumper = 0;
	
	//I2C
	public static final int i2cLidarAddress = 0x62;
}