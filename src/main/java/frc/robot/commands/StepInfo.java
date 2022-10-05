package frc.robot.commands;

// import frc.robot.subsystems.RobotSystem;

public class StepInfo {
    private double duration;
    private double speed;
    private double turn;

    public StepInfo(double duration, double speed, double turn) {
        this.duration = duration;
        this.speed = speed;
        this.turn = turn;
    }

    public double getDuration() {
        return duration;
    }

    public double getSpeed() {
        return speed;
    }

    public double getTurn() {
        return turn;
    }
}
