package org.firstinspires.ftc.teamcode.util

import com.qualcomm.robotcore.hardware.Gamepad
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.drive.mecanumDrive

class Drivetrain : Mechanism {
    // TODO: Fix motor directions
    private val lf = NextMotor("lf")
    private val lb = NextMotor("lb")
    private val rf = NextMotor("rf")
    private val rb = NextMotor("rb")

    fun manual(gamepad: Gamepad) = mecanumDrive(lf, rf, lb, rb, gamepad)
}