package org.firstinspires.ftc.teamcode.util.mechanisms

import com.pedropathing.ivy.commands.Commands.infinite
import com.pedropathing.ivy.commands.Commands.instant
import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.teamcode.util.Context
import kotlin.math.sign

class Intake(private val context: Context) {
    private val intake by lazy { context.hardwareMap.get(DcMotorEx::class.java, "intake") }

    val on = instant { intake.power = 1.0 }.requiring(intake)
    val off = instant { intake.power = 0.0 }.requiring(intake)
    val reverse = instant { intake.power = -1.0 }.requiring(intake)
    fun manual(throttle: () -> Float) = infinite { intake.power = throttle().toDouble().sign }.requiring(intake)
}