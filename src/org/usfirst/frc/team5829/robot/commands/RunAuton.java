package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;
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
		addSequential(new DriveForward(5));
	}
	
	public void StartLeft(){
		System.out.println("center switch");
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if('L' == gameData.charAt(0)){
			addSequential(new DriveForward(7600));
			//addSequential(new DriveTurn(-2280, 'L'));
			addSequential(new DriveForward(19770));
			//addSequential(new DriveTurn(2640, 'R'));
		}else{
			//addSequential(new DriveForward(8670));
			//addSequential(new DriveTurn(1171, 'R'));
			//addSequential(new DriveForward(11165));
		}	
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
