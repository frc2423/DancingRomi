package frc.robot.commands;

import frc.robot.subsystems.DancingRobot;

public class Choreography {
    public void init() {
        DancingRobot.SpinClockwise(1);
        DancingRobot.SpinCounterClockwise(0.5);
        DancingRobot.Pause(3);
    }
}
