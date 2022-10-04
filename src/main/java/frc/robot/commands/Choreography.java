package frc.robot.commands;

import frc.robot.subsystems.DancingRobot;

/**
 * Here's where you can teach your robot how to dance!
 * The robot knows how to do a few things. It can:
 *  - Spin 
 *  - Move forward and back
 *  - Pause
 * 
 * All you need to do is tell it how long you want it to do each step!
 * All of the durations are in seconds. For example, if you want your robot
 * to spin clockwise for two seconds, you would write:
 * 
 * DancingRobot.SpinClockwise(2.0); 
 * 
 * It's important that you write the "two" as "2.0". Robots are precise!
 * Also, don't forget the semicolon at the end of the line, otherwise
 * the robot won't understand your instruction. 
 * 
 * What can you make your robot do?
 */
public class Choreography {
    public void init() {
        DancingRobot.Pause(1);
        DancingRobot.Forward(2,0.5);
        DancingRobot.Backward(2,-0.5);
    }
}
