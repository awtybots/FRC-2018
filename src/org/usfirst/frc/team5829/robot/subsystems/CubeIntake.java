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
	public static Spark intakeMotor = new Spark(RobotMap.intake);
	public static Spark intakeMotor2 = new Spark(RobotMap.intake2);
	//public static Spark intakeLift = new Spark(RobotMap.intakeLift);
	public static final double intakeSpeed = .85;
	public static final double outtakeSpeed = .45;
	public static final double liftSpeed = .45;
	
    public void initDefaultCommand() {
		// This is a useless comment
        // Set the default command for a subsystem here.
		intakeMove.set(DoubleSolenoid.Value.kReverse);
        setDefaultCommand(new IntakeCube(0));
    }
    
    public static void Intake(double speed){
		if(Math.abs(speed) > .65) {
			intakeMotor.set(-outtakeSpeed);
			intakeMotor2.set(outtakeSpeed);
		}else{
			intakeMotor.set(0);
			intakeMotor2.set(0);
		}
    }
    
    public static void Outtake(double speed){
		if(Math.abs(speed) > .25) {
			intakeMotor.set(intakeSpeed);
			intakeMotor2.set(-intakeSpeed);
		}
    }
    
    public static void IntakeMove(int openClose) {
		if(openClose == 1)
			intakeMove.set(DoubleSolenoid.Value.kReverse);
		if(openClose == 0)
			intakeMove.set(DoubleSolenoid.Value.kForward);
		
    }
}

