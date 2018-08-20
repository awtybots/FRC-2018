package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.CubeIntake;
import org.usfirst.frc.team5829.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 *
 */
public class RunAuton extends CommandGroup {
	
	String gameData;

    public RunAuton(int option){
    	
    	int o = option; 
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	System.out.println(o);
    	switch(o){
    		case 0: DriveForward();
    				break;
    		case 1: StartLeft();
    				break;
    		case 2: StartCenter();
    				break;
    		case 3: StartRight();
    				break;
    		case 4: LeftScale();
    				break;
    		case 5: RightScale();
    				break;
    	}
    }
    
	
	public void DriveForward(){
		System.out.println("called from runnauton");
		addSequential(new DriveForward(65));
	}
	
	public void StartLeft(){
		System.out.println("center switch");
//		gameData = Robot.getGameData();
//		if('L' == gameData.charAt(0)){
//			addSequential(new DriveForward(20)); // drive to pile of cubes
//			addSequential(new DriveTurn(-45)); // turn away from pile of cubes
//			addSequential(new DriveForward(50)); // drive away from cubes
//			addSequential(new DriveTurn(45)); // turn to face switch
//			addSequential(new ArmSetMove(11895)); // move arm to switch height
//			addSequential(new DriveForward(30)); // drive towards switch to score
//			addSequential(new IntakeCube(1));
//		}else{
			//addSequential(new DriveForward(8670));
			//addSequential(new DriveTurn(45));
			//addSequential(new DriveForward(11165));
			//addSequential(new DriveTurn(-45));
//		}
	}
	public void StartCenter(){
		
	}
	public void StartRight(){
		
	}
	public void LeftScale(){
		
	}
	public void RightScale(){
		
	}
}
