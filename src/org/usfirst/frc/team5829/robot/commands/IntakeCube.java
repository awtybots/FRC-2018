package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.CubeIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCube extends Command {
	public double intakeSpeed, outtakeSpeed;
	public int intakeMove;
	
    public IntakeCube(int move) {
		intakeMove = move;
        requires(Robot.intake);
    }

    // Called just before this Command runs thefirst time
    protected void initialize(){}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		intakeSpeed = Robot.oi.xbox2.getRawAxis(3);
		intakeSpeed = Robot.oi.xbox.getRawAxis(3);
		outtakeSpeed = Robot.oi.xbox2.getRawAxis(2);
		outtakeSpeed = Robot.oi.xbox.getRawAxis(2);
		
		if (Math.abs(intakeSpeed) < .5) {
			intakeSpeed = 0;
		}if (Math.abs(outtakeSpeed) < .5) {
			outtakeSpeed = 0;
		}
		CubeIntake.Intake(intakeSpeed);
		CubeIntake.Outtake(outtakeSpeed);
		CubeIntake.IntakeMove(intakeMove);
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
