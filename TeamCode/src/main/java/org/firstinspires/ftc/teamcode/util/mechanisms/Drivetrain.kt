package org.firstinspires.ftc.teamcode.util.mechanisms

import com.qualcomm.robotcore.hardware.Gamepad
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.drive.mecanumDrive
import dev.nextftc.robot.drive.mecanumDriveFieldCentric
import org.firstinspires.ftc.teamcode.util.Hardware
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

class Drivetrain : Mechanism {
    private val lf = Hardware.motor("lf")
    private val lb = Hardware.motor("lb")
    private val rf = Hardware.motor("rf").apply { direction = NextMotor.Direction.REVERSE }
    private val rb = Hardware.motor("fb").apply { direction = NextMotor.Direction.REVERSE }
    private val motors = listOf(lf, lb, rf, rb)

    private val pinpoint = Hardware.pinpoint("pinpoint")

    fun robot(gamepad: Gamepad) = mecanumDrive(lf, rf, lb, rb, gamepad)
    fun field(gamepad: Gamepad) = mecanumDriveFieldCentric(lf, rf, lb, rb, gamepad, pinpoint.pose.heading::toDouble)

    fun resetHeading() = pinpoint.resetPosAndIMU()

    override fun periodic() {
        pinpoint.update()
    }
}