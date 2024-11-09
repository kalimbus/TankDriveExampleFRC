// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  WPI_TalonFX leftmotor = new WPI_TalonFX(23);
  WPI_TalonFX rightmotor = new WPI_TalonFX(21);
  WPI_TalonFX slaveleft = new WPI_TalonFX(24);
  WPI_TalonFX slaveright = new WPI_TalonFX(22);

  public DifferentialDrive AARobot = new DifferentialDrive(leftmotor,rightmotor);

  public drivetrain() {
    leftmotor.configFactoryDefault();
    rightmotor.configFactoryDefault();
    slaveleft.configFactoryDefault();
    slaveright.configFactoryDefault();

    leftmotor.setNeutralMode(NeutralMode.Brake);
    rightmotor.setNeutralMode(NeutralMode.Brake);
    slaveleft.setNeutralMode(NeutralMode.Brake);
    slaveright.setNeutralMode(NeutralMode.Brake);

    slaveleft.follow(leftmotor);
    slaveright.follow(rightmotor);

    leftmotor.setInverted(false);
    rightmotor.setInverted(false);
    slaveleft.setInverted(InvertType.FollowMaster);
    slaveright.setInverted(InvertType.FollowMaster);
  }
  public void setMaxSpeed(double maxSpeed){
    AARobot.setMaxOutput(maxSpeed);
  }
  public void drive (double forward, double turn){
  AARobot.arcadeDrive(forward, turn);
  }
 
  public void drive(XboxController xBox){
    drive(-xBox.getRawAxis(4), xBox.getRawAxis(1));
  }
  
  public void driveL(double Lmotor){
    leftmotor.set(Lmotor);
  }

  public void driveR(double Rmotor){
    rightmotor.set(Rmotor);
  }

  public void stop(){
    leftmotor.set(0);
    rightmotor.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
