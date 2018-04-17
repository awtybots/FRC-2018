package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.SplitArcade;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Spark;
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
	
	public static final double CONSTANT_RAMP_LIMIT = 0.05;
	public static double prevStraight = 0;
	public static double prevRotate = 0;
	public static double prevLeft = 0;
	public static double prevRight = 0;
	public static boolean allowRamped = true;
	
	public double desiredAngle, initialAngle;
	public boolean firstTime = true;
	public boolean isFinished;
	public double leftSpeed = .45;
	public double rightSpeed = .45;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new SplitArcade());
    	rightMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0 ,10);
    	leftBackMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	rightMiddleMotor.setSensorPhase(false);
    	leftBackMotor.setSensorPhase(true);
    }
    
    public void setRamped(boolean a) {
    	this.allowRamped = a;
    }
    
    public boolean getRamped() {
    	return this.allowRamped;
    }
    
    public static void TankDrive(double leftSpeed, double rightSpeed) {
    	
    	if(leftSpeed - prevLeft > CONSTANT_RAMP_LIMIT)
    	{
    		leftSpeed = prevLeft + CONSTANT_RAMP_LIMIT;
    	}
    	else if(prevLeft - leftSpeed > CONSTANT_RAMP_LIMIT)
    	{
    		leftSpeed = prevLeft - CONSTANT_RAMP_LIMIT;
    	}
    	
    	if(rightSpeed - prevRight > CONSTANT_RAMP_LIMIT)
    	{
    		rightSpeed = prevRight + CONSTANT_RAMP_LIMIT;
    	}
    	else if(prevRight - rightSpeed > CONSTANT_RAMP_LIMIT)
    	{
    		rightSpeed = prevRight - CONSTANT_RAMP_LIMIT;
    	}
    	
    	prevLeft = leftSpeed;
    	prevRight = rightSpeed;
    	leftBackMotor.set(ControlMode.PercentOutput,leftSpeed);
    	leftMiddleMotor.set(ControlMode.PercentOutput,leftSpeed);
    	leftFrontMotor.set(ControlMode.PercentOutput,leftSpeed);
    	rightBackMotor.set(ControlMode.PercentOutput,rightSpeed);
    	rightMiddleMotor.set(ControlMode.PercentOutput,rightSpeed);
    	rightFrontMotor.set(ControlMode.PercentOutput,rightSpeed);
    }
    public static void SplitArcade(double straight, double rotate) {
    	//double value = leftMiddleMotor.getSelectedSensorPosition(0);
    	//System.out.println(value);
    	if(straight - prevStraight > CONSTANT_RAMP_LIMIT)
    	{
    		straight = prevStraight + CONSTANT_RAMP_LIMIT;
    	}
    	else if(prevStraight - straight > CONSTANT_RAMP_LIMIT)
    	{
    		straight = prevStraight - CONSTANT_RAMP_LIMIT;
    	}
    	
    	if(rotate - prevRotate > CONSTANT_RAMP_LIMIT){
    		rotate = prevRotate + CONSTANT_RAMP_LIMIT;
    	}
    	else if(prevRotate - rotate > CONSTANT_RAMP_LIMIT)
    	{
    		rotate = prevRotate - CONSTANT_RAMP_LIMIT;
    	}
    	
    	prevStraight = straight;
    	prevRotate = rotate;
    	
    	leftFrontMotor.set(ControlMode.PercentOutput,(straight + rotate));
    	leftMiddleMotor.set(ControlMode.PercentOutput,(straight + rotate));
    	leftBackMotor.set(ControlMode.PercentOutput,(straight + rotate));
    	rightFrontMotor.set(ControlMode.PercentOutput,-(straight - rotate));
    	rightMiddleMotor.set(ControlMode.PercentOutput,-(straight - rotate));
    	rightBackMotor.set(ControlMode.PercentOutput,-(straight - rotate));
    }
    
    public double encoderToInches(double ticks){
    	double diameter = 4;
    	double circumference = 2*Math.PI*diameter;
    	double rotations = ticks/1024;
    	double inches = rotations*circumference;
    	return inches;	
    }
    
    public static void resetEncoder() {
    	rightMiddleMotor.setSelectedSensorPosition(0 ,0, 10);
    	leftBackMotor.setSelectedSensorPosition(0, 0, 10);
    	
    }
    
    //turn drive
    public boolean turnDegrees(double dg) {
    	double yaw = Robot.navx.getYaw();
    	double angle = Robot.navx.getAngle();
    	;
    	if (angle > 360 || angle <-360 ) {
    		angle = ((angle%360) * 360);
    		
    	}
    	SmartDashboard.putNumber("angle value", angle);
    	
    	
    	double motorSpeed = .4;
    	//double motorSpeed = ((difference/dg));
    	if (dg > 0) {
    	if (angle < (dg-5)   ) {
    		
    		leftFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		leftMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		leftBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		rightBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		rightMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		rightFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
    		isFinished = false;
    	}
    	else if (angle > (dg+5)  ) {
    		leftFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    		leftMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    		leftBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    		rightBackMotor.set(ControlMode.PercentOutput, motorSpeed);
    		rightMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
    		rightFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
    		isFinished = false;
    		
    	}
    	else if (angle < (dg+4.9) && angle > (dg-4.9)) {
    		leftFrontMotor.set(ControlMode.PercentOutput, 0);
    		leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    		leftBackMotor.set(ControlMode.PercentOutput, 0);
    		rightBackMotor.set(ControlMode.PercentOutput, 0);
    		rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    		rightFrontMotor.set(ControlMode.PercentOutput, 0);
    		isFinished = true;
 
    		}
    	return isFinished;
    	}
    	else if (dg < 0) {
        	if (angle < (dg - 5)   ) {
        		leftFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		leftMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		leftBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		rightBackMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		rightMiddleMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		rightFrontMotor.set(ControlMode.PercentOutput, -motorSpeed);
        		isFinished = false;
        	}
        	else if (angle > (dg+5)  ) {
        		leftFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
        		leftMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
        		leftBackMotor.set(ControlMode.PercentOutput, motorSpeed);
        		rightBackMotor.set(ControlMode.PercentOutput, motorSpeed);
        		rightMiddleMotor.set(ControlMode.PercentOutput, motorSpeed);
        		rightFrontMotor.set(ControlMode.PercentOutput, motorSpeed);
        		isFinished= false;
        	}
        	else if (angle < (dg+4.9) && angle > (dg-4.9)) {
        		leftFrontMotor.set(ControlMode.PercentOutput, 0);
        		leftMiddleMotor.set(ControlMode.PercentOutput, 0);
        		leftBackMotor.set(ControlMode.PercentOutput, 0);
        		rightBackMotor.set(ControlMode.PercentOutput, 0);
        		rightMiddleMotor.set(ControlMode.PercentOutput, 0);
        		rightFrontMotor.set(ControlMode.PercentOutput, 0);
        		isFinished= true;
     
        	}
        	return isFinished;
    	}
    	SmartDashboard.putBoolean("Finished turn?", isFinished);
    	return isFinished;
    }
    
    //drive straight
    public boolean driveForward(double ds) {
  
    	double diameter = 4;
    	double circumference = diameter;
    	double distance = ds;
    	double lBMP = leftBackMotor.getSelectedSensorPosition(0);
    	double rBMP = rightMiddleMotor.getSelectedSensorPosition(0);
    	double distanceDrivenRight = ((rBMP/1024)*circumference);
    	double distanceDrivenLeft =((lBMP/1024)*circumference);
    	double avgDistanceDriven = ((distanceDrivenRight + distanceDrivenLeft)/2);
    
    	SmartDashboard.putNumber("Auto Left Driven", distanceDrivenLeft);
    	SmartDashboard.putNumber("Auto Right Driven", distanceDrivenRight);
    	
    	
        //Are we there yet?
    	
    	if ((/* distanceDrivenRight > -distance || */ distanceDrivenLeft > -distance) && distance > 0 ) {
    		/*if (Math.abs(distanceDrivenRight )> Math.abs(distanceDrivenLeft)) {
    			leftSpeed = leftSpeed + 0.0075;
    		}
    		else if (Math.abs(distanceDrivenLeft) > Math.abs(distanceDrivenRight) ) {
    			leftSpeed= leftSpeed - 0.0025;
    		}*/
    		leftFrontMotor.set(ControlMode.PercentOutput, -leftSpeed);
    		leftMiddleMotor.set(ControlMode.PercentOutput, -leftSpeed);
    		leftBackMotor.set(ControlMode.PercentOutput, -leftSpeed);
    		rightBackMotor.set(ControlMode.PercentOutput, rightSpeed);
    		rightMiddleMotor.set(ControlMode.PercentOutput, rightSpeed);
    		rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
    		return false;

    	}
    	else if (Math.abs(distanceDrivenLeft) <  Math.abs(distance) && distance < 0) {
    		/*if (Math.abs(distanceDrivenRight )> Math.abs(distanceDrivenLeft)) {
    			leftSpeed = leftSpeed + 0.0035;
    			return false;
    		}
    		else if (Math.abs(distanceDrivenLeft) > Math.abs(distanceDrivenRight) ) {
    			leftSpeed= leftSpeed - 0.0035;
    		}*/
    		leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
    		leftMiddleMotor.set(ControlMode.PercentOutput, leftSpeed);
    		leftBackMotor.set(ControlMode.PercentOutput, leftSpeed);
    		rightBackMotor.set(ControlMode.PercentOutput, -rightSpeed);
    		rightMiddleMotor.set(ControlMode.PercentOutput, -rightSpeed);
    		rightFrontMotor.set(ControlMode.PercentOutput, -rightSpeed);

    		return false;
    		
    	}
    	else  {
    		leftFrontMotor.set(ControlMode.PercentOutput, 0);
    		leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    		leftBackMotor.set(ControlMode.PercentOutput, 0);
    		rightBackMotor.set(ControlMode.PercentOutput, 0);
    		rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    		rightFrontMotor.set(ControlMode.PercentOutput, 0);
    		return true;
    	}

    }
    
    //curve drive
    public void curve(double changeX, double changeY, double changeAngle) {
    	
    	desiredAngle = changeAngle;
    	SmartDashboard.putNumber("Desired Angle", desiredAngle);
    	double r = changeY/Math.sin(changeAngle);
    	double speed = .25;
    	double radiusRight = r +15.5;
    	double radiusLeft = r - 15.5;
    	double time = 3;
    	// Low gear max RPM is 530
    	double rPMMax = 530;
    	double rPSMax = rPMMax/60;
    	double diameter = 4;
    	double circumference = 4;
    	double velocityMax = rPSMax*circumference;
    	
    	if (firstTime = true) {
        	double initialLeftDriven = leftBackMotor.getSelectedSensorPosition(0);
        	double initialRightDriven = rightMiddleMotor.getSelectedSensorPosition(0);
        	initialAngle = Robot.navx.getAngle();
        	double initialXPos = 30;
        	double initialYPos = 14.5;
        	double desiredXPos = initialXPos + changeX;
        	double desiredYPos = initialYPos + changeY;
        	
        	firstTime = false;

    	}
    	double arcForRight = ((desiredAngle)/360)*(2*3.14*radiusRight);
    	double arcForLeft = ((desiredAngle)/360)*(2*3.14*radiusLeft);
    	double velocityRight = (arcForRight)/time;
    	double velocityLeft = -(arcForLeft)/time;
    	double percentageRight = velocityRight/velocityMax;
    	double percentageLeft = velocityLeft/velocityMax;
    	
    	if (changeX > 0 && changeY > 0 ) {
    		if (changeAngle > 0 ) {
    			if ((Robot.navx.getAngle() < desiredAngle) && (Math.abs(encoderToInches(leftBackMotor.getSelectedSensorPosition(0))) < ((2*3.14*(r)*((180-changeAngle)/360)) ) ) && (Math.abs(encoderToInches(rightMiddleMotor.getSelectedSensorPosition(0))) < ((2*3.14*(r)*((180-changeAngle)/360)) ))) {
    				
    		leftFrontMotor.set(ControlMode.PercentOutput, percentageLeft/2);
    		leftMiddleMotor.set(ControlMode.PercentOutput, percentageLeft/2);
    		leftBackMotor.set(ControlMode.PercentOutput, percentageLeft/2);
    		rightFrontMotor.set(ControlMode.PercentOutput, percentageRight/2);
    		rightMiddleMotor.set(ControlMode.PercentOutput, percentageRight/2);
    		rightBackMotor.set(ControlMode.PercentOutput, percentageRight/2);
    		}
    			else if (Math.abs(Robot.navx.getAngle()) >= desiredAngle || encoderToInches(leftBackMotor.getSelectedSensorPosition(0)) > ((2*3.14*(r)*((180-changeAngle)/360)))) {
    				leftFrontMotor.set(ControlMode.PercentOutput, 0);
    	    		leftMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    		leftBackMotor.set(ControlMode.PercentOutput, 0);
    	    		rightBackMotor.set(ControlMode.PercentOutput, 0);
    	    		rightMiddleMotor.set(ControlMode.PercentOutput, 0);
    	    		rightFrontMotor.set(ControlMode.PercentOutput, 0);
    			}
    		}
    	}
 
    	
    	
    	
    	
    }
}