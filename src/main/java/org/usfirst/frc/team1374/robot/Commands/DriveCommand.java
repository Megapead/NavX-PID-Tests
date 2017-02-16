package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Robot;




/**
 * Created by Gabriel on 2017-02-10.
 */
public class DriveCommand extends Command{

    public DriveCommand()
    {
        requires(Robot.drive);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.drive.setSetpoint( Robot.drive.pidWriter(OI.getTurn(),OI.getPIDToggle()));
        Robot.drive.pidRun(OI.getSpeed());
        //Robot.drive.arcadeDrive(OI.getSpeed(),OI.getTurn());
        //Robot.drive.PIDSwitch(OI.getPIDToggle());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}

