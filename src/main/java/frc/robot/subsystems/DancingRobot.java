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

    public static void SpinCounterClockwise(double seconds, double turnSpeed) {
        DancingRobot.AddStep(new StepInfo(seconds, turnSpeed, 0));
    }

    public static void Square(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, 0, 0.6));
        DancingRobot.AddStep(new StepInfo(seconds, 0.405, 0));
        DancingRobot.AddStep(new StepInfo(seconds, 0, 0.6));
        DancingRobot.AddStep(new StepInfo(seconds, 0.405, 0));
        DancingRobot.AddStep(new StepInfo(seconds, 0, 0.6));
        DancingRobot.AddStep(new StepInfo(seconds, 0.405, 0));
        DancingRobot.AddStep(new StepInfo(seconds, 0, 0.6));
        DancingRobot.AddStep(new StepInfo(seconds, 0.405, 0));
    }

    public static void ClockwiseCircle(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, 0.6, 0.6));
    }
    // When the turn speed is the same as the motor speed, only one wheel turns

    public static void CounterClockwiseCircle(double seconds) {
        DancingRobot.AddStep(new StepInfo(seconds, -0.6, -0.6));
    }

    public static void ChaCha(double seconds) {
        DancingRobot.ClockwiseCircle(0.25);
        DancingRobot.CounterClockwiseCircle(0.5);
        DancingRobot.ClockwiseCircle(0.5);
        DancingRobot.CounterClockwiseCircle(0.5);
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

    public static void Forward(double seconds, double forwardspeed) {
        DancingRobot.AddStep(new StepInfo(seconds, forwardspeed, 0));
    }

    public static void Backward(double seconds, double backwardspeed) {
        DancingRobot.AddStep(new StepInfo(seconds, backwardspeed, 0));
    }
}
