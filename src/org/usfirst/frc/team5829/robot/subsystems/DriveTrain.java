package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.TankDriveCommand;
import org.usfirst.frc.team5829.robot.commands.SplitArcade;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static TalonSRX leftBackMotor = new TalonSRX(RobotMap.leftBackMotor);
	public static TalonSRX leftFrontMotor = new TalonSRX(RobotMap.leftFrontMotor);
	public static TalonSRX rightBackMotor = new TalonSRX(RobotMap.rightBackMotor);
	public static TalonSRX rightFrontMotor = new TalonSRX(RobotMap.rightFrontMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SplitArcade());
    }
    
    public static void TankDrive(double leftSpeed, double rightSpeed) {
    	leftBackMotor.set(ControlMode.PercentOutput, leftSpeed);
    	leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
    	rightBackMotor.set(ControlMode.PercentOutput, rightSpeed);
    	rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
    }
    
    public static void SplitArcade(double straight, double rotate) {
    	leftFrontMotor.set(ControlMode.PercentOutput, (straight + rotate));
    	leftBackMotor.set(ControlMode.PercentOutput, (straight + rotate));
    	rightFrontMotor.set(ControlMode.PercentOutput, (straight - rotate));
    	rightBackMotor.set(ControlMode.PercentOutput, (straight - rotate));
    }
}

