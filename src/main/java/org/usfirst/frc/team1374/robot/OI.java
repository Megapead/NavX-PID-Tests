package org.usfirst.frc.team1374.robot;


import org.usfirst.frc.team1374.robot.Util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static final Xbox360Controller JS_Driver = new Xbox360Controller(0,0.15);


    public static double getTurn(){return JS_Driver.getLeftXAxis();}
    public static double getSpeed(){return JS_Driver.getRightTrigger()-JS_Driver.getLeftTrigger();}
    public static boolean getPIDToggle(){return JS_Driver.getButtonA();}


}

