package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.Hang;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hanger extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static Spark leftHangerMotor = new Spark(RobotMap.leftHangMotor);
    public static Spark rightHangerMotor = new Spark(RobotMap.rightHangMotor);
    public static final double hangSpeed = .75;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Hang(false));
    }
    
    public static void Hang(boolean shouldHang) {
        if(shouldHang){
            leftHangerMotor.set(-hangSpeed);
            rightHangerMotor.set(hangSpeed);
        }else{
            leftHangerMotor.set(0);
            rightHangerMotor.set(0);
        }
    }
}

