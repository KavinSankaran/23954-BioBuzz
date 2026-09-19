package org.firstinspires.ftc.teamcode.util.mechanisms

import com.pedropathing.ivy.commands.Commands.infinite
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.IMU
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.teamcode.util.Context
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

class Drivetrain(private val context: Context) {
    // TODO: Fix motor directions
    private val lf by lazy { context.hardwareMap.get(DcMotorEx::class.java, "lf") }
    private val rf by lazy { context.hardwareMap.get(DcMotorEx::class.java, "rf") }
    private val lb by lazy { context.hardwareMap.get(DcMotorEx::class.java, "lb") }
    private val rb by lazy { context.hardwareMap.get(DcMotorEx::class.java, "rb") }

    private val imu by lazy { (context.hardwareMap.get(IMU::class.java, "imu"))
        .apply { initialize(IMU.Parameters(RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.UP,
            RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)))
        }
    }

    fun robot(gamepad: Gamepad) = infinite {
        val y = -gamepad.left_stick_y
        val x = gamepad.left_stick_x * 1.1
        val rx = gamepad.right_stick_x

        val denominator = max(abs(y) + abs(x) + abs(rx), 1.0)

        lf.power = (y + x + rx) / denominator
        lb.power = (y - x + rx) / denominator
        rf.power = (y - x - rx) / denominator
        rb.power = (y + x - rx) / denominator
    }.requiring(this)

    fun field(gamepad: Gamepad) = infinite {
        val y = -gamepad.left_stick_y
        val x = gamepad.left_stick_x * 1.1
        val rx = gamepad.right_stick_x

        val heading = imu.robotYawPitchRollAngles.getYaw(AngleUnit.RADIANS)

        val rotX = (x * cos(-heading) - y * sin(-heading)) * 1.1
        val rotY = x * sin(-heading) + y * cos(-heading)

        val denominator = max(abs(rotY) + abs(rotX) + abs(rx), 1.0)

        lf.power = (rotY + rotX + rx) / denominator
        lb.power = (rotY - rotX + rx) / denominator
        rf.power = (rotY - rotX - rx) / denominator
        rb.power = (rotY + rotX - rx) / denominator
    }.requiring(this)
}