package org.usfirst.frc.team5829.robot.subsystems;
import org.usfirst.frc.team5829.robot.commands.LIDARCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Counter;
public class LIDARSubsystem extends Subsystem {
    public void initDefaultCommand() {
        setDefaultCommand(new LIDARCommand());
    }
    private static final int CALIBRATION_OFFSET = -6;
    private Counter counter;
    private int printedWarningCount = 5;
    public void initLIDAR(DigitalSource source) {
    	counter = new Counter(source);
    	counter.setMaxPeriod(1.0);
    	counter.setSemiPeriodMode(true);
    	counter.reset();
    }
    public double getDistCm(boolean rounded) {
    	double cm;
    	if(counter.get()>0.1) {
    		if(printedWarningCount-- > 0) {
    			System.out.println("LIDARLitePWM: Waiting for distance measurement");
    		}
    		return 0;
    	}
    	cm = (counter.getPeriod()*1000000.0/10.0)+CALIBRATION_OFFSET;
    	if(!rounded) {
    		return cm;
    	}else {
    		return Math.floor(cm*10)/10;
    	}
    }
    public double getDistIn(boolean rounded) {
    	double in = getDistCm(true)*0.393700787;
    	if(!rounded) {
    		return in;
    	}else {
    		return Math.floor(in*10)/10;
    	}    	
    }
}