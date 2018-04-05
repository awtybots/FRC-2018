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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new SplitArcade());
    	rightMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0 ,10);
    	leftMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	// rightMiddleMotor.setSensorPhase(true);
    	leftMiddleMotor.setSensorPhase(true);
    	leftMiddleMotor.setSelectedSensorPosition(0, 0, 10);
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
    	double value = leftMiddleMotor.getSelectedSensorPosition(0);
    	System.out.println(value);
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
    	
    	leftFrontMotor.set(ControlMode.PercentOutput,straight + rotate);
    	leftMiddleMotor.set(ControlMode.PercentOutput,straight + rotate);
    	leftBackMotor.set(ControlMode.PercentOutput,straight + rotate);
    	rightFrontMotor.set(ControlMode.PercentOutput,straight - rotate);
    	rightMiddleMotor.set(ControlMode.PercentOutput,straight - rotate);
    	rightBackMotor.set(ControlMode.PercentOutput,straight - rotate);
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
    	leftMiddleMotor.setSelectedSensorPosition(0, 0, 10);
    	
    }
    
    public static void driveForward(double distance)
    {    	
    	double right = rightMiddleMotor.getSelectedSensorPosition(0);
    	double left = leftMiddleMotor.getSelectedSensorPosition(0);
    	while (right < distance || left < distance){
    		if(right > distance || left > distance){
    			break;
    		}
    		right = rightMiddleMotor.getSelectedSensorPosition(0);
        	left = leftMiddleMotor.getSelectedSensorPosition(0);
        	System.out.println(left+" "+right);
    		TankDrive(.2, -.2);
    	}
    	
    	TankDrive(0, 0);
    }
    
    public static void driveTurn(double distance, char turn){
    	double right = rightMiddleMotor.getSelectedSensorPosition(0);
    	double left = leftMiddleMotor.getSelectedSensorPosition(0);
    	
    	while (right < distance || left < distance){
    		if(right > distance || left > distance){
    			break;
    		}
    		right = rightMiddleMotor.getSelectedSensorPosition(0);
        	left = leftMiddleMotor.getSelectedSensorPosition(0);
    		System.out.println(left+" "+right);
    		if(turn == 'L'){
    			TankDrive(-.2, -.2);
    		}else if(turn == 'R'){
    			TankDrive(.2, .2);
    		}
    	}
    	TankDrive(0, 0);
    }
}