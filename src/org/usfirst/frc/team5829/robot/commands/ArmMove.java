package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmMove extends Command {
	public int armSpeed;
	public int armPot;

    public ArmMove(int speed, int position) {
    	armSpeed = speed;
    	armPot = position;
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Arm.armMoveMotor(armSpeed);
    	Arm.armMovePiston(armPot);
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
