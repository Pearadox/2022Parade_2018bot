// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pincher extends SubsystemBase {
  private DoubleSolenoid dsolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2,5);
  /** Creates a new pincher. */
  public pincher() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void openPinchers (){
    dsolenoid.set(Value.kForward);
  }

  public void closePinchers(){
    dsolenoid.set(Value.kReverse);
  }

  public void togglePinchers(){
    if(dsolenoid.get() == Value.kForward){
      dsolenoid.set(Value.kReverse);
    }
    else{
      dsolenoid.set(Value.kForward);
    }
  }
}
