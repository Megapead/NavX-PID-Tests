package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Robot;

/**
 * Created by Gabriel on 2017-02-14.
 */
public class autonomousDriveGyroCommand extends Command {
    static Timer time = new Timer();
    double power,turn,delay;
    public autonomousDriveGyroCommand(double store, double angle, double speed)
    {
        requires(Robot.drive);
        delay = store;
        power = speed;
        turn = angle;

    }
    @Override
    protected void initialize() {
        time.reset();
        time.start();

    }

    @Override
    protected void execute() {
        Robot.drive.setSetpoint(turn);
        Robot.drive.pidRun(power);
    }

    @Override
    protected boolean isFinished() {

        if(time.hasPeriodPassed(delay))
            return true;
        else
            return false;

    }

    @Override
    protected void end() {
        Robot.drive.pidRun(0);
    }

    @Override
    protected void interrupted() {
        Robot.drive.pidRun(0);
        Robot.drive.zeroYaw();
    }
}
