/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5829.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5829.robot.commands.RunAuton;
import org.usfirst.frc.team5829.robot.subsystems.Arm;
import org.usfirst.frc.team5829.robot.subsystems.CubeIntake;
import org.usfirst.frc.team5829.robot.subsystems.DriveTrain;

<<<<<<< HEAD
//import com.kauailabs.navx.frc.AHRS;
=======
import com.kauailabs.navx.frc.AHRS;
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveTrain driveBase = new DriveTrain();
	public static final Arm arm = new Arm();
	public static final CubeIntake intake = new CubeIntake();
	
<<<<<<< HEAD
	//public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
=======
	public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git
	public static OI oi;

	Command autonomousCommand;
	SendableChooser autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
<<<<<<< HEAD
		//Robot.navx.resetDisplacement();
		//UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		
		//cam0.setFPS(8);
		
		//autoChooser = new SendableChooser();
		
		/*String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//center auto
		autoChooser.addDefault("Drive Forward", new RunAuton(gameData.charAt(0), 0)); //drive forward
		
		//auto for Switch
		if(gameData.charAt(0) == 'L') {
			autoChooser.addObject("Left Switch", new RunAuton(gameData.charAt(0), 2)); //left switch
			autoChooser.addObject("Center Switch", new RunAuton(gameData.charAt(0), 1)); //center switch
		}else {
			autoChooser.addObject("Right Switch", new RunAuton(gameData.charAt(0), 3));
			autoChooser.addObject("Center Switch", new RunAuton(gameData.charAt(1), 1)); //center switch
		}
		
		//auto for Scale
		if(gameData.charAt(1) == 'L') {
			autoChooser.addObject("Left Scale", new RunAuton(gameData.charAt(1), 4)); //left scale
		}else {
			autoChooser.addObject("Right Scale", new RunAuton(gameData.charAt(1), 5)); //right scale
		}
		SmartDashboard.putData("Auto mode", autoChooser);*/
=======
		Robot.navx.resetDisplacement();
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		
		cam0.setFPS(8);
		
		autoChooser = new SendableChooser();
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//center auto
		autoChooser.addDefault("Drive Forward", new RunAuton(gameData.charAt(0), 0)); //drive forward
		
		//auto for Switch
		if(gameData.charAt(0) == 'L') {
			autoChooser.addObject("Left Switch", new RunAuton(gameData.charAt(0), 2)); //left switch
			autoChooser.addObject("Center Switch", new RunAuton(gameData.charAt(0), 1)); //center switch
		}else {
			autoChooser.addObject("Right Switch", new RunAuton(gameData.charAt(0), 3));
			autoChooser.addObject("Center Switch", new RunAuton(gameData.charAt(1), 1)); //center switch
		}
		
		//auto for Scale
		if(gameData.charAt(1) == 'L') {
			autoChooser.addObject("Left Scale", new RunAuton(gameData.charAt(1), 4)); //left scale
		}else {
			autoChooser.addObject("Right Scale", new RunAuton(gameData.charAt(1), 5)); //right scale
		}
		SmartDashboard.putData("Auto mode", autoChooser);
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Robot.driveBase.leftMiddleMotor.setSelectedSensorPosition(0,0,0);
		Robot.driveBase.rightMiddleMotor.setSelectedSensorPosition(0, 0, 0);
<<<<<<< HEAD
		//Robot.navx.reset();
=======
		Robot.navx.reset();
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		Robot.driveBase.leftMiddleMotor.getSelectedSensorPosition(0);
		Robot.driveBase.rightMiddleMotor.getSelectedSensorPosition(0);
<<<<<<< HEAD
		//Robot.navx.reset();
		
		//Robot.navx.resetDisplacement();
=======
		Robot.navx.reset();
		
		Robot.navx.resetDisplacement();
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		Robot.driveBase.leftMiddleMotor.setSelectedSensorPosition(0, 0, 0);
		Robot.driveBase.rightMiddleMotor.setSelectedSensorPosition(0, 0, 0);
<<<<<<< HEAD
		//Robot.navx.reset();
=======
		Robot.navx.reset();
>>>>>>> branch 'master' of https://github.com/awtybots/FRC-2018.git
		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
