package org.firstinspires.ftc.teamcode.util.mechanisms

import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.util.Hardware
import kotlin.math.abs
import kotlin.math.max

class Drivetrain {
    private val lf by lazy { Hardware.motor("fl") }
    private val lb by lazy { Hardware.motor("bl") }
    private val rf by lazy { Hardware.motor("fr")
        .apply { direction = DcMotorSimple.Direction.REVERSE }
    }
    private val rb by lazy { Hardware.motor("br")
        .apply { direction = DcMotorSimple.Direction.REVERSE }
    }

    fun robot(gamepad: Gamepad) {
        val x = gamepad.left_stick_x.toDouble()
        val y = -gamepad.left_stick_y.toDouble()
        val rx = gamepad.right_stick_x.toDouble()

        val denominator = max(abs(x) + abs(y) + abs(rx), 1.0)

        lf.power = (y + x + rx) / denominator
        lb.power = (y - x + rx) / denominator
        rf.power = (y - x - rx) / denominator
        rb.power = (y + x - rx) / denominator
    }
}