package org.usfirst.frc.team1374.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Gabriel on 2017-02-14.
 */
public class autoCommand extends CommandGroup{
    public autoCommand()
    {

        addSequential(new autonomousDriveGyroCommand(1,0,0.5));


        addSequential(new autonomousDriveGyroCommand(4,0,0.5));
        addSequential(new autonomousDriveGyroCommand(0.5,0,0));
        addSequential(new autonomousDriveGyroCommand(2,-90,0));

        addSequential(new autonomousDriveGyroCommand(4,-90,0.5));
        addSequential(new autonomousDriveGyroCommand(0.5,-90,0));
        addSequential(new autonomousDriveGyroCommand(2,-180,0));

        addSequential(new autonomousDriveGyroCommand(4,-180,0.5));
        addSequential(new autonomousDriveGyroCommand(0.5,-180,0));
        addSequential(new autonomousDriveGyroCommand(2,90,0));

        addSequential(new autonomousDriveGyroCommand(4,-180,0.5));
        addSequential(new autonomousDriveGyroCommand(0.5,-180,0));
        addSequential(new autonomousDriveGyroCommand(2,90,0));

        addSequential(new autonomousDriveGyroCommand(4,90,0.5));
        addSequential(new autonomousDriveGyroCommand(0.5,90,0));
        addSequential(new autonomousDriveGyroCommand(2,0,0));



    }
}
