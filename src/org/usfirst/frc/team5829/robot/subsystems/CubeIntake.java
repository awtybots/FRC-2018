package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.IntakeCube;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static DoubleSolenoid intakeMove = new DoubleSolenoid(RobotMap.IntakeOpen, RobotMap.IntakeClose); 
	public static TalonSRX leftIntakeMotor = new TalonSRX(RobotMap.intakeLeft);
	public static TalonSRX rightIntakeMotor = new TalonSRX(RobotMap.intakeRight);
	public static Spark intakeLift = new Spark(RobotMap.intakeLift);
	public static final double intakeSpeed = .65;
	public static final double liftSpeed = .35;
	
    public void initDefaultCommand() {
    	// This is a useless comment
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeCube(0));
    }
    
    public static void Intake(double speed){
    	if(Math.abs(speed) > .65) {
    		leftIntakeMotor.set(ControlMode.PercentOutput,intakeSpeed);
    		rightIntakeMotor.set(ControlMode.PercentOutput,intakeSpeed);
    	}else{
    		leftIntakeMotor.set(ControlMode.PercentOutput,0);
    		rightIntakeMotor.set(ControlMode.PercentOutput,0);
    	}
    }
    
    public static void Outtake(double speed){
    	if(Math.abs(speed) > .65) {
    		leftIntakeMotor.set(ControlMode.PercentOutput,-intakeSpeed);
    		rightIntakeMotor.set(ControlMode.PercentOutput,-intakeSpeed);
    	}
    }
    public static void IntakeLifter(int lift) {
    	if(lift == 1)
    		intakeLift.set(liftSpeed);
    	else if(lift == -1)
    		intakeLift.set(-liftSpeed);
    	else
    		intakeLift.set(.2);
    		
    }
}

