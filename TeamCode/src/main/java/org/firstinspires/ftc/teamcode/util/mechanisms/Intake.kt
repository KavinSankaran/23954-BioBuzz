package org.firstinspires.ftc.teamcode.util.mechanisms

import com.pedropathing.ivy.commands.Commands.infinite
import com.pedropathing.ivy.commands.Commands.instant
import org.firstinspires.ftc.teamcode.util.Hardware
import kotlin.math.sign

class Intake {
    private val intake by lazy { Hardware.motor("intake") }

    val on = instant { intake.power = 1.0 }.requiring(this)
    val off = instant { intake.power = 0.0 }.requiring(this)
    val reverse = instant { intake.power = -1.0 }.requiring(this)
    fun manual(throttle: () -> Float) = infinite { intake.power = throttle().toDouble().sign }.requiring(this)
}