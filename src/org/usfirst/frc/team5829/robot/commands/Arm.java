package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.ArmLifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Arm extends Command {
	public int armSpeed;

    public Arm(int speed) {
    	armSpeed = speed;
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Math.abs(armSpeed) < .2) {
    		armSpeed = 0;
    	}
    	
    	if(armSpeed == -1){
    		ArmLifter.armDown();
    	}
    	
    	if(armSpeed == 1){
    		ArmLifter.armUp();
    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
