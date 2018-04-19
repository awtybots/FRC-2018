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
import com.kauailabs.navx.frc.AHRS;
import org.usfirst.frc.team5829.robot.commands.DriveForward;
public class Robot extends TimedRobot {
	public static final DriveTrain driveBase = new DriveTrain();
	public static final Arm arm = new Arm();
	public static final CubeIntake intake = new CubeIntake();
	public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
	public static OI oi;
	public double m_autoInitTime = 0;
	Command autonomousCommand;
	SendableChooser autoChooser;
	@Override
	public void robotInit() {
		Robot.navx.resetDisplacement();
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		cam0.setFPS(8);
		autoChooser = new SendableChooser<String>();
		//center auto
		//autoChooser.addDefault("Drive Forward", new RunAuton(0)); //drive forward
//		autoChooser.addDefault("Switch Auto", new RunAuton(1));
		//auto for Switch
		/*if(gameData.charAt(0) == 'L') {
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
		}*/
		SmartDashboard.putData("Auto mode", autoChooser);
		oi = new OI();
	}
	@Override
	public void disabledInit(){}
	@Override
	public void disabledPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void autonomousInit(){
		
//		autonomousCommand = new DriveForward(10);
//		autonomousCommand.start();
		Robot.navx.reset();
    	Robot.navx.resetDisplacement();
		m_autoInitTime = Timer.getFPGATimestamp();
	}
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
		if(Timer.getFPGATimestamp()-m_autoInitTime <= 2){
			Robot.driveBase.TankDrive(.5, -.5);
		}else{
			Robot.driveBase.TankDrive(0, 0);
		}
	}
	@Override
	public void teleopInit(){
		//Robot.driveBase.leftMiddleMotor.setSelectedSensorPosition(0, 0, 0);
		//Robot.driveBase.rightMiddleMotor.setSelectedSensorPosition(0, 0, 0);
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
		Robot.driveBase.resetEncoder();
	}
	@Override
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("Lidar Value", Robot.arm.getLiftHeightInches());
		SmartDashboard.putNumber("rightEncoder", Robot.driveBase.leftBackMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("leftEncoder", Robot.driveBase.rightMiddleMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("NAVX Angle", Robot.navx.getAngle());
	}
	@Override
	public void testPeriodic(){}
}