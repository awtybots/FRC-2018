package org.usfirst.frc.team5829.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Electrical extends Subsystem {
    // Just leave this alone for now
	public void initDefaultCommand() {}
    
    // All our sensors and stuff go here
    public Compressor compressr;
    public AnalogInput pressure;
    
    // All our commands for controlling the things go here
    public Electrical(){
    	compressr = new Compressor(30);
    	compressr.setClosedLoopControl(true);
    }
    public void enableCompressor(){
    	compressr.setClosedLoopControl(true);
    	compressr.start();
    }
}

