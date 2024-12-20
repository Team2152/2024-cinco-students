// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private CANSparkMax m_intake;
  
  public Intake() {
    m_intake = new CANSparkMax(5, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    System.out.println("IN " + m_intake.get());
  }

  private void setIntakeSpeed(double speed) {
    m_intake.set(speed);
  }

  public Command setIntakeSpeedCmd(double speed) {
    return runOnce(()->setIntakeSpeed(speed));
  }
}
