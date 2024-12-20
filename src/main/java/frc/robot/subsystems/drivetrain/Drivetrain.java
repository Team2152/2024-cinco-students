// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.InputConstants;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive m_drivetrain;

  private CANSparkMax m_frontLeft;
  private CANSparkMax m_frontRight;
  private CANSparkMax m_backLeft;
  private CANSparkMax m_backRight;

  public Drivetrain() {
    m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
    m_frontRight = new CANSparkMax(2, MotorType.kBrushless);
    m_backLeft = new CANSparkMax(3, MotorType.kBrushless);
    m_backRight = new CANSparkMax(4, MotorType.kBrushless);

    m_frontRight.setInverted(true);
    m_backRight.setInverted(true);

    m_drivetrain = new DifferentialDrive(m_frontLeft, m_frontRight);
    m_backLeft.follow(m_frontLeft);
    m_backRight.follow(m_frontRight);

    m_drivetrain.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    System.out.println("FL " + m_frontLeft.get());
  }

  private void drive(double y, double x) {
    m_drivetrain.arcadeDrive(y, x);
  }

  public Command driveCmd(DoubleSupplier y, DoubleSupplier x) {
    double out_y = MathUtil.applyDeadband(y.getAsDouble(), InputConstants.kDeadband);
    double out_x = MathUtil.applyDeadband(x.getAsDouble(), InputConstants.kDeadband);

    return runOnce(()->{
      drive(out_y, out_x);
    });
  }
}
