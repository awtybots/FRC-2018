package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.IntakeCube;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static TalonSRX leftIntakeMotor = new TalonSRX(RobotMap.intakeLeft);
	public static TalonSRX rightIntakeMotor = new TalonSRX(RobotMap.intakeRight);
	public static final double intakeSpeed = .65;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeCube());
    }
    
    public static void Intake(double speed)
    {
    	if(Math.abs(speed) > .65) {
    		leftIntakeMotor.set(ControlMode.PercentOutput, intakeSpeed);
    		rightIntakeMotor.set(ControlMode.PercentOutput, intakeSpeed);
    	}
    	else
    	{
    		leftIntakeMotor.set(ControlMode.PercentOutput, 0);
    		rightIntakeMotor.set(ControlMode.PercentOutput, 0);
    	}
    }
    
    public static void Outtake(double speed)
    {
    	if(Math.abs(speed) > .65) {
    		leftIntakeMotor.set(ControlMode.PercentOutput, -intakeSpeed);
    		rightIntakeMotor.set(ControlMode.PercentOutput, -intakeSpeed);
    	}
    }
}

