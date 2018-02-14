package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.Arm;
import org.usfirst.frc.team5829.robot.commands.SplitArcade;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmLifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static TalonSRX leftArm = new TalonSRX(RobotMap.leftArm);
	public static TalonSRX rightArm = new TalonSRX(RobotMap.rightArm);
	public static final double armSpeed = 0.65;
	
    public void initDefaultCommand(){
    	setDefaultCommand(new Arm(0));
    }
    
    public static void armDown() {
    	leftArm.set(ControlMode.PercentOutput, armSpeed);
    	rightArm.set(ControlMode.PercentOutput, -armSpeed);
    }
    public static void armUp() {
    	leftArm.set(ControlMode.PercentOutput, -armSpeed);
    	rightArm.set(ControlMode.PercentOutput, armSpeed);
    }
    public static void armOff()
    {
    	leftArm.set(ControlMode.PercentOutput, 0);
    	rightArm.set(ControlMode.PercentOutput, 0);
    }
}

