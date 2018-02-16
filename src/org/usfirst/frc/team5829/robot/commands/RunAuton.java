package org.usfirst.frc.team5829.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RunAuton extends CommandGroup {

    public RunAuton(char position, int option) {
    	
    	char p = position;
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
    	switch(o) {
    		case 0: DriveForward(p);
    				break;
    		case 1: CenterSwitch(p);
    				break;
    		case 2: LeftSwitch(p);
    				break;
    		case 3: RightSwitch(p);
    				break;
    		case 4: LeftScale(p);
    				break;
    		case 5: RightScale(p);
    				break;
    	}
    }
    
	
	public void DriveForward(char p) {
		
	}
	
	public void CenterSwitch(char p) {
		
	}
	
	public void LeftSwitch(char p) {
		
	}
	
	public void RightSwitch(char p) {
		
	}
	
	public void LeftScale(char p) {
		
	}
	
	public void RightScale(char spot) {
		
	}
}
