package org.usfirst.frc.team1374.robot.Subsystems;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Created by Gabriel on 2017-02-10.
 */
public class DriveSubsystem extends PIDSubsystem {

    AHRS ahrs = new AHRS(SPI.Port.kMXP);
    static Talon left1 = new Talon(0);
    static Talon left2 = new Talon(1);
    static Talon right1 = new Talon(2);
    static Talon right2 = new Talon(3);
    //static double setpointInit = 0;
    //boolean REDBUTTON = false;
    static double pidGet; //PID NUMBERS ARE STORED HERE
    static double hold;
    int temp;

    public DriveSubsystem()
    {
        super("Drive PID: ",0.03,0,0);
        getPIDController().setContinuous(true);
        getPIDController().setInputRange(-180,180);
        getPIDController().setOutputRange(-1,1);
        //getPIDController().setSetpoint(setpointInit);
        getPIDController().setAbsoluteTolerance(2);
        ahrs.reset();
        getPIDController().enable();
        hold = getPIDController().getSetpoint();
    }
    /*
        Used to set the setpoint
     */
    public double pidWriter(double in,boolean reset)
    {
        if (reset) {
            hold = 0;
            zeroYaw();
        }
        hold += (3*Math.pow(in,3));
        temp = (int)hold/180;
        hold = hold*Math.pow(-1,temp) -temp;
        return hold;
    }
    /*
    Zeros the PID + yaw to current position
     */
    public void zeroYaw()
    {
        ahrs.zeroYaw();
        getPIDController().setSetpoint(0);
    }
    public void keepYaw()
    {
        getPIDController().setSetpoint(ahrs.getYaw());
        arcadeDrive(0.8,0);
    }
    public double returnSetpoint()
    {
        return getPIDController().getSetpoint();
    }
    public double getPIDOutput()
    {
        return getPIDController().get();
    }
    public void tankDrive(double left,double right)
    {
        left1.set(left);
        left2.set(left);
        right1.set(-right);
        right2.set(-right);
        System.out.println("Gryo Values: "+ahrs.pidGet());
    }

    public void pidRun(double in)
    {
        arcadeDrive(in,pidGet);
    }
    public void arcadeDrive(double speed,double turn)
    {
        tankDrive((-speed)+turn,(-speed)-turn);
    }


    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return ahrs.pidGet();
    }

    @Override
    protected void usePIDOutput(double output) {
        pidGet = output;
    }
}
