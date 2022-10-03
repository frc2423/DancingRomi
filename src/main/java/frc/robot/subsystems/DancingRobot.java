package frc.robot.subsystems;

import java.util.ArrayList;

import frc.robot.commands.StepInfo;

// Add methods to this file to give the robot more moves!

public class DancingRobot {
    private static ArrayList<StepInfo> steps = new ArrayList<StepInfo>();

    public static void AddStep(StepInfo step) {
        steps.add(step);
    }

    public static void SpinClockwise(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, 0.5, 0));
    }

    public static void SpinClockwise(double seconds, double turnSpeed) {
        DancingRobot.AddStep(new StepInfo(seconds, turnSpeed, 0));
    }

    public static void SpinCounterClockwise(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, -0.5, 0));
    }

    public static void Pause(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, 0, 0));
    }

    public static void step(RobotSystem robot, double speed, double turn) {
        robot.drive(speed, turn);
    }

    public static StepInfo getStep(int step) {
        return DancingRobot.steps.get(step);
    }

    public static int numSteps() {
        return DancingRobot.steps.size();
    }
}
