package subcommands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GyroAutonDrive extends Command {
	//drives straight using arcade drive, adjusts using gyro
	
	double kP;
	double kI;
	double kD;
	double preError;
	double integral;
	double turningError;
	double setPoint; //heading the robot starts
	double time;
	double timePerIteration;
	double iterations;
	double i;
	public GyroAutonDrive (double time) {
		kP = 0.2;
		kI = 0.01;
		kD = 0.01;
		integral = 0.0;
		preError = 0.0;
		turningError = 0.0;
		this.time = time;
		this.iterations = 65;
	}
	@Override 
	protected void initialize() {
		setPoint = Robot.navx.getAngle();
	}
	
	@Override
	protected void execute() {
		turningError = Math.abs(setPoint - Robot.navx.getAngle());
		integral = integral + (turningError *0.004);
		double derivative = (turningError - preError) / 0.004;
		double output = (kP * turningError) + (kI * integral) + (kD * derivative);
		
		if(output > 0.3)
			output = 0.3;
		if(output < -0.3)
			output = -0.3;
		
		Robot.driveBase.TankDrive(0.5 + output,(-1)* 0.55 - output);
		Timer.delay(0.004);
		System.out.println("i: " + i + "output: " + output);
		i++;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (i >= iterations);
	}

}
