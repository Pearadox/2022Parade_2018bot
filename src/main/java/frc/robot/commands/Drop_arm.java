// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.arm;

public class Drop_arm extends CommandBase {
  /** Creates a new Drop_arm. */
  private arm arm;
  public Drop_arm(arm m_arm) {  
    // Use addRequirements() here to declare subsystem dependencies.
    arm = m_arm;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.dropArm();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.holdArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (arm.adjustAngle()< 90);
  }
}
