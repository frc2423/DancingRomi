// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DancingRobot;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;


import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.RobotSystem;
import frc.robot.NtHelper;


public class RunDance extends CommandBase {
    private Drivetrain drivetrain;
    private int step;
    private RobotSystem robot;
    private Timer timer = new Timer();
    private StepInfo currentStep;
    private Choreography dance = new Choreography();

    public RunDance(Drivetrain drive) {
        drivetrain = drive;
        step = 0;
        robot = new RobotSystem(drivetrain, timer);
        addRequirements(drivetrain);
        dance.init();
        timer.start();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        currentStep = DancingRobot.getStep(step);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        updateVariables();
        
        if(timer.hasElapsed(currentStep.getDuration())){
            step = (step + 1) % (DancingRobot.numSteps());
            timer.reset();
            timer.start();
            currentStep = DancingRobot.getStep(step);
        }
        robot.drive(currentStep.getSpeed(), currentStep.getTurn());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        timer.reset();
        robot.drive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return step >= DancingRobot.numSteps();
    }

    // update any variables to uses during steps
    private void updateVariables() {
 
        robot.angle = drivetrain.getGyroAngleZ();
        robot.distance = drivetrain.getAverageDistanceInch();
        robot.time = timer.get();
        NtHelper.setNumber("/robot/angle", robot.angle);
        NtHelper.setNumber("/robot/speed", robot.speed);
        NtHelper.setNumber("/robot/distance", robot.distance);
        NtHelper.setNumber("/robot/joystickXAxis", robot.joystickXAxis);
        NtHelper.setNumber("/robot/joystickYAxis", robot.joystickYAxis);
        NtHelper.setNumber("/robot/time", robot.time);
        NtHelper.setNumber("/robot/step", step);
        NtHelper.setBoolean("/robot/isButtonAPressed", robot.isButtonAPressed);
        NtHelper.setBoolean("/robot/isButtonBPressed", robot.isButtonBPressed);
        NtHelper.setBoolean("/robot/isButtonXPressed", robot.isButtonXPressed);
        NtHelper.setBoolean("/robot/isButtonYPressed", robot.isButtonYPressed);
        NtHelper.setBoolean("/robot/wasButtonAReleased", robot.wasButtonAReleased);
        NtHelper.setBoolean("/robot/wasButtonBReleased", robot.wasButtonBReleased);
        NtHelper.setBoolean("/robot/wasButtonXReleased", robot.wasButtonXReleased);
        NtHelper.setBoolean("/robot/wasButtonYReleased", robot.wasButtonYReleased);
    }
}
