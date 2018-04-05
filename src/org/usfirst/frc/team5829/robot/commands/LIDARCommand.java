package org.usfirst.frc.team5829.robot.commands;
import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
public class LIDARCommand extends Command {
    public LIDARCommand() {
        requires(Robot.lidarSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try{
    		Robot.lidarSubsystem.initLIDAR(new DigitalInput(RobotMap.DIO.LIDAR_PORT));
    	}catch(Exception e){}
    }
    protected void execute() {
    	SmartDashboard.getNumber("LIDAR dist",Robot.lidarSubsystem.getDistIn(true));
    	System.out.println(Robot.lidarSubsystem.getDistIn(true));
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end(){}
    protected void interrupted(){}
}