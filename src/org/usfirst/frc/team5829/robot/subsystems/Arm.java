package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.ArmMove;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static TalonSRX leftArm = new TalonSRX(RobotMap.leftArm);
	public static TalonSRX rightArm = new TalonSRX(RobotMap.rightArm);
	public static final double armSpeed = 0.65;
	public static DoubleSolenoid armMove = new DoubleSolenoid(RobotMap.arm_down,RobotMap.arm_up);
	
    public void initDefaultCommand(){
    	setDefaultCommand(new ArmMove(0));
    }
    
    public static void armMoveMotor(int upOrDown) {
    	if(upOrDown==-1){
    		leftArm.set(ControlMode.PercentOutput, armSpeed);
    		rightArm.set(ControlMode.PercentOutput, -armSpeed);
    	}else if(upOrDown==1){
    		leftArm.set(ControlMode.PercentOutput, -armSpeed);
        	rightArm.set(ControlMode.PercentOutput, armSpeed);
    	}else{
        	leftArm.set(ControlMode.PercentOutput, 0);
        	rightArm.set(ControlMode.PercentOutput, 0);    		
    	}
    }
    public static void armMovePiston(int upOrDown){
    	if(upOrDown == 0)
    		armMove.set(DoubleSolenoid.Value.kForward);
    	if(upOrDown == 1)
    		armMove.set(DoubleSolenoid.Value.kReverse);
    }
}

