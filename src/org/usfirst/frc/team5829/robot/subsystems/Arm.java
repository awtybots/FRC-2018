package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Lidar;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.ArmMove;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static Spark liftMotor1 = new Spark(RobotMap.liftMotor1);
	public static Spark liftMotor2 = new Spark(RobotMap.liftMotor2);
	public static Spark liftMotor3 = new Spark(RobotMap.liftMotor3);
	public static Spark liftMotor4 = new Spark(RobotMap.liftMotor4);
	public static final double armSpeed = 0.50;
	public static DoubleSolenoid armMove = new DoubleSolenoid(RobotMap.arm_down,RobotMap.arm_up);
//	public static DoubleSolenoid bikeBreak = new DoubleSolenoid(RobotMap.breakClose, RobotMap.breakOpen);
	public static DigitalInput bumper = new DigitalInput(RobotMap.bumper);
	public static DigitalInput limit = new DigitalInput(RobotMap.limit);
	//public static Lidar lidarLift;
	
    public void initDefaultCommand(){
    	setDefaultCommand(new ArmMove(0, 0));
    }
    
    public static void armMoveMotor(int upOrDown) {
    	if(upOrDown == -1){
    		if(bumper.get() == true) {
//    			bikeBreak.set(DoubleSolenoid.Value.kForward);
    			liftMotor1.set(armSpeed);
    			liftMotor2.set( -armSpeed);
    			liftMotor3.set( armSpeed);
    			liftMotor4.set( -armSpeed);
    		}
    		else
    		{
//    			bikeBreak.set(DoubleSolenoid.Value.kReverse);
        		liftMotor1.set(0);
        		liftMotor2.set( 0);
        		liftMotor3.set( 0);
        		liftMotor4.set(0);
    		}
    	}else if(upOrDown == 1){
    		if(limit.get() == true) {
//    			bikeBreak.set(DoubleSolenoid.Value.kForward);
    			liftMotor1.set(-armSpeed);
    			liftMotor2.set( armSpeed);
    			liftMotor3.set( -armSpeed);
    			liftMotor4.set( armSpeed);
    		}
    		else
    		{
//    			bikeBreak.set(DoubleSolenoid.Value.kReverse);
        		liftMotor1.set(0);
        		liftMotor2.set( 0);
        		liftMotor3.set( 0);
        		liftMotor4.set( 0);
    		}
    	}else{
//    		bikeBreak.set(DoubleSolenoid.Value.kReverse);
    		liftMotor1.set(0);
    		liftMotor2.set( 0);
    		liftMotor3.set( 0); 
    		liftMotor4.set( 0);
    	}
    }
    public static void armMovePiston(int upOrDown){
    	if(upOrDown == 0)
    		armMove.set(DoubleSolenoid.Value.kForward);
    	if(upOrDown == 1)
    		armMove.set(DoubleSolenoid.Value.kReverse);
    }
    
    public static boolean getBumperValue(){
    	if(bumper.get() == false) {
    		return false;
    	}
    	else
    		return true;
    }
    
   /* public double getLiftHeightInches()
    {
    	return lidarLift.getDistanceIn() + 4.5;
    }*/
}

