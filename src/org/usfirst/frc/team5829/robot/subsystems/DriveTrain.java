package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.SplitArcade;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static TalonSRX leftBackMotor = new TalonSRX(RobotMap.leftBackMotor);
	public static TalonSRX leftMiddleMotor = new TalonSRX(RobotMap.leftMiddleMotor);
	public static TalonSRX leftFrontMotor = new TalonSRX(RobotMap.leftFrontMotor);
	public static TalonSRX rightBackMotor = new TalonSRX(RobotMap.rightBackMotor);
	public static TalonSRX rightMiddleMotor = new TalonSRX(RobotMap.rightMiddleMotor);
	public static TalonSRX rightFrontMotor = new TalonSRX(RobotMap.rightFrontMotor);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SplitArcade());
    }
    
    public static void TankDrive(double leftSpeed, double rightSpeed) {
    	leftBackMotor.set(ControlMode.PercentOutput, leftSpeed);
    	leftMiddleMotor.set(ControlMode.PercentOutput, leftSpeed);
    	leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
    	rightBackMotor.set(ControlMode.PercentOutput, rightSpeed);
    	rightMiddleMotor.set(ControlMode.PercentOutput, rightSpeed);
    	rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
    }
    
    public static void SplitArcade(double straight, double rotate) {
    	leftFrontMotor.set(ControlMode.PercentOutput, (straight + rotate));
    	leftMiddleMotor.set(ControlMode.PercentOutput, (straight + rotate));
    	leftBackMotor.set(ControlMode.PercentOutput, (straight + rotate));
    	rightFrontMotor.set(ControlMode.PercentOutput, (straight - rotate));
    	rightMiddleMotor.set(ControlMode.PercentOutput, (straight - rotate));
    	rightBackMotor.set(ControlMode.PercentOutput, (straight - rotate));
    }
    
    public double encoderToInches(double ticks) {
    	double diameter = 4; 
    	double circumference = 2*Math.PI*diameter;
    	double rotations = ticks/1024;
    	double inches = rotations*circumference;
    	
    	return inches;
    }
    
    public boolean turnDegrees(double dg) {

    	//double yaw = Robot.navx.getYaw();
    	double angle = Robot.navx.getAngle();
    	boolean isFinished = false;
    	
    	if(angle > 360 || angle < -360) {
    		angle = ((angle%360)*360);
    	}
    	
    	SmartDashboard.putNumber("angle value:", angle);
    	
    	double motorSpeed = .7;
    	if(dg > 0) {
    		if(angle < (dg-5)) {
    			leftBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	isFinished = false;
    		}else if(angle > (dg+5)){
    			leftBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	isFinished = false;
    		}else if(angle < (dg+4.9) && angle > (dg-4.9)) {
    			leftBackMotor.set(ControlMode.PercentOutput, 0);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, 0);
    	    	rightBackMotor.set(ControlMode.PercentOutput, 0);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, 0);
    	    	isFinished = true;
    		}
    		
    	}
    	
    	if(dg < 0) {
    		if(angle < (dg-5)) {
    			leftBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    	    	isFinished = false;
    		}else if(angle > (dg+5)){
    			leftBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    	    	isFinished = false;
    		}else if(angle < (dg+4.9) && angle > (dg-4.9)) {
    			leftBackMotor.set(ControlMode.PercentOutput, 0);
    	    	leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    	leftFrontMotor.set(ControlMode.PercentOutput, 0);
    	    	rightBackMotor.set(ControlMode.PercentOutput, 0);
    	    	rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    	rightFrontMotor.set(ControlMode.PercentOutput, 0);
    	    	isFinished = true;
    		}
    	}
    	
    	SmartDashboard.putBoolean("Turn finished:", isFinished);
    	return isFinished;
    }
    
    public void resetEncoderPosition() { 
    	leftMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	rightMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    }
    
    public boolean driveForward(double ds, double speed) {
    	
    	double motorSpeed = speed;
    	double diameter = 4;
    	double circumference = diameter;
    	double distance = ds;
    	double lBMP = leftMiddleMotor.getSelectedSensorPosition(0);
    	double rBMP = rightMiddleMotor.getSelectedSensorPosition(0);
    	double distanceDrivenRight = ((rBMP/1024)*circumference);
    	double distanceDrivenLeft = ((lBMP/1024)*circumference);
    	double avgDistanceDriven = ((distanceDrivenRight + distanceDrivenLeft)/2);
    	
    	SmartDashboard.putNumber("Auto Left Driven:", distanceDrivenLeft);
    	SmartDashboard.putNumber("Auto Right Driven:", distanceDrivenRight);
    	
    	if((distanceDrivenLeft > -distance) && distance > 0) {
    		leftBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	leftMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	leftFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	rightBackMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	rightMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	rightFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	
	    	return false;
    	}else if(Math.abs(distanceDrivenLeft) < Math.abs(distance) && distance < 0) {
    		leftBackMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	leftMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	leftFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	rightBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	rightMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	rightFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	
	    	return false;
    	}else
    		leftBackMotor.set(ControlMode.PercentOutput, 0);
    	leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    	leftFrontMotor.set(ControlMode.PercentOutput, 0);
    	rightBackMotor.set(ControlMode.PercentOutput, 0);
    	rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    	rightFrontMotor.set(ControlMode.PercentOutput, 0);
    	
    	return true;
    }
}