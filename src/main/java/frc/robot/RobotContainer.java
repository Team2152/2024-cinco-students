// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.outtake.Outtake;

public class RobotContainer {
  public Drivetrain m_drivetrain;
  public Intake m_intake;
  public Outtake m_outtake;
  
  private CommandXboxController m_driverController;

  public RobotContainer() {
    m_drivetrain = new Drivetrain();
    m_driverController = new CommandXboxController(0);
    
    // m_intake = new Intake();
    // m_outtake = new Outtake();

    configureBindings();
  }

  private void configureBindings() {
    m_drivetrain.setDefaultCommand(
      m_drivetrain.driveCmd(
        () -> -m_driverController.getLeftY(), 
        () -> m_driverController.getRightX()
    ));

    // m_driverController.leftTrigger()
    //   .whileTrue(m_intake.setIntakeSpeedCmd(.1))
    //   .whileFalse(m_intake.setIntakeSpeedCmd(0));

    // m_driverController.rightTrigger()
    //   .whileTrue(m_outtake.setOuttakeSpeedCmd(.3))
    //   .whileFalse(m_outtake.setOuttakeSpeedCmd(0));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
