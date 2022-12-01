// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.ArmCycle;

public class arm extends SubsystemBase {
  /** Creates a new arm. */
  TalonSRX arm = new TalonSRX(20);
  AnalogPotentiometer pot = new AnalogPotentiometer(0, 295, 0);
  public arm() {
    setDefaultCommand(new ArmCycle(this));
    SmartDashboard.putNumber("Pot", adjustAngle());
    SmartDashboard.putNumber("HoldValue", calculateHold());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run    
    SmartDashboard.putNumber("Pot", adjustAngle());
    SmartDashboard.putNumber("HoldValue", calculateHold());
  }
  
  public void liftArm() {
    arm.set(ControlMode.PercentOutput, 0.5);
  }

  public void dropArm() {
    arm.set(ControlMode.PercentOutput, .05);

  }
  public void holdArm() {
    arm.set(ControlMode.PercentOutput, calculateHold());
  }

  public double calculateHold() {
    return (Math.sin(Math.toRadians(adjustAngle())) * 0.35);
  }

  public double adjustAngle() {
    return (pot.get() * -1 + 270);
  }
}
