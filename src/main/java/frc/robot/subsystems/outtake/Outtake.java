// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.outtake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OuttakeConstants;

public class Outtake extends SubsystemBase {
  private CANSparkMax m_outtake;
  
  public Outtake() {
    m_outtake = new CANSparkMax(6, MotorType.kBrushless);
    m_outtake.setInverted(OuttakeConstants.kOuttakeReversed);

  }

  @Override
  public void periodic() {
    System.out.println("OUT " + m_outtake.get());
  }

  private void setOuttakeSpeed(double speed) {
    m_outtake.set(speed);
  }

  public Command setOuttakeSpeedCmd(double speed) {
    return runOnce(()->setOuttakeSpeed(speed));
  }
}
