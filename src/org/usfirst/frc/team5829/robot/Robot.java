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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import subcommands.GyroAutonDrive;
import org.usfirst.frc.team5829.robot.commands.RunAuton;
import org.usfirst.frc.team5829.robot.subsystems.Arm;
import org.usfirst.frc.team5829.robot.subsystems.CubeIntake;
import org.usfirst.frc.team5829.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5829.robot.subsystems.Hanger;
import com.kauailabs.navx.frc.AHRS;
import org.usfirst.frc.team5829.robot.commands.DriveForward;
public class Robot extends TimedRobot {
	
	public static final DriveTrain driveBase = new DriveTrain();
	public static final Arm arm = new Arm();
	public static final CubeIntake intake = new CubeIntake();
	public static final Hanger hanger = new Hanger();
	public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
	public static OI oi;
	public double m_autoInitTime = 0;
	public static String gameData;
//	public boolean autoHasStarted = false;
	Command autonomousCommand;
	SendableChooser autoChooser;
	
	@Override
	public void robotInit() {
		Robot.navx.resetDisplacement();
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		cam0.setFPS(8);
		autoChooser = new SendableChooser<String>();
		//center auto
		autoChooser.addDefault("Drive Forward", new RunAuton(0)); //drive forward
		
		/*//auto for Switch
		autoChooser.addDefault("Starting Left", new RunAuton(1));
		autoChooser.addDefault("Starting Center", new RunAuton(2));
		autoChooser.addDefault("Starting Right", new RunAuton(3));
		
		//auto for Scale
		autoChooser.addDefault("Starting Left Scale", new RunAuton(4));
		autoChooser.addDefault("Starting Right Scale", new RunAuton(5));*/
		
		SmartDashboard.putData("Auto mode", autoChooser);
		oi = new OI();
	}
	@Override
	public void disabledInit(){}
	@Override
	public void disabledPeriodic(){
		Scheduler.getInstance().run();
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	@Override
	public void autonomousInit(){
		Robot.navx.reset();
    	Robot.navx.resetDisplacement();
		m_autoInitTime = Timer.getFPGATimestamp();
//		if(gameData.length() >0) {
//			autoHasStarted = true;
//			autonomousCommand = (Command) autoChooser.getSelected();
//			autonomousCommand.start();
//		}else {
//			gameData = DriverStation.getInstance().getGameSpecificMessage();
//		}
	}
	@Override
	public void autonomousPeriodic(){
//		if(gameData.length() >0 && autoHasStarted == false) {
//			autoHasStarted = true;
//			autonomousCommand = (Command) autoChooser.getSelected();
//			autonomousCommand.start();
//		}else {
//			gameData = DriverStation.getInstance().getGameSpecificMessage();
//		}
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
		driveBase.setBreakMode(true);
		Scheduler.getInstance().run();
		
		
		/*if(Timer.getFPGATimestamp()-m_autoInitTime <= 2){
			Robot.driveBase.TankDrive(.5, -.5);
		}else{
			Robot.driveBase.TankDrive(0, 0);
		}*/
		
		
	}
	/*public static String getGameData() {
		return gameData;
	}*/
	@Override
	public void teleopInit(){
		Robot.driveBase.leftMiddleMotor.setSelectedSensorPosition(0, 0, 0);
		Robot.driveBase.rightMiddleMotor.setSelectedSensorPosition(0, 0, 0);
		Robot.arm.liftMotor1.setSelectedSensorPosition(0, 0, 0);
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
		Robot.driveBase.resetEncoder();
		Robot.arm.resetEncoder();
	}
	@Override
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
		driveBase.setBreakMode(true);
		//SmartDashboard.putNumber("Lidar Value", Robot.arm.getLiftHeightInches());
		SmartDashboard.putNumber("liftEncoder", Robot.arm.liftMotor1.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("rightEncoder", Robot.driveBase.leftMiddleMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("leftEncoder", Robot.driveBase.rightMiddleMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("NAVX Angle", Robot.navx.getAngle());
	}
	@Override
	public void testPeriodic(){}
}