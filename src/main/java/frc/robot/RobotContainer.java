// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArmCycle;
import frc.robot.commands.Drop_arm;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LiftArm;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.pincher;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final arm m_arm = new arm();
  private final pincher m_pincher = new pincher();

  public final Joystick driverJoystick = new Joystick(0);
  

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  
  JoystickButton btn5 = new JoystickButton(driverJoystick, 5);
  JoystickButton btn6 = new JoystickButton(driverJoystick, 6);
  JoystickButton btn1 = new JoystickButton(driverJoystick, 1);
  JoystickButton btn2 = new JoystickButton(driverJoystick, 2);
  JoystickButton btn4 = new JoystickButton(driverJoystick, 4);
  JoystickButton btn3= new JoystickButton(driverJoystick, 3);
  private void configureButtonBindings() {
    btn5.whenPressed(new LiftArm(m_arm));
    btn6.whenPressed(new Drop_arm(m_arm));
    btn1.whenPressed(new RunCommand(m_pincher::openPinchers,m_pincher));
    btn2.whenPressed(new RunCommand(m_pincher::closePinchers,m_pincher));
    btn4.whenPressed(new InstantCommand(m_pincher::togglePinchers,m_pincher));
    btn3.whenPressed(new ArmCycle(m_arm));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
