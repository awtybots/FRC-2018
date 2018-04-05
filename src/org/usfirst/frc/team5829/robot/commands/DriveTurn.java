package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurn extends Command {
	
	public double value;
	public char turn;

    public DriveTurn(double distance, char direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	turn = direction;
    	value = distance;
    	requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize(){}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveTrain.resetEncoder();
    	DriveTrain.driveTurn(value, turn);
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
