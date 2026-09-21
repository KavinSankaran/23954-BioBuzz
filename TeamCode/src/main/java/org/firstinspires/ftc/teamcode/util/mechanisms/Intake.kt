package org.firstinspires.ftc.teamcode.util.mechanisms

import com.pedropathing.ivy.commands.Commands.infinite
import com.pedropathing.ivy.commands.Commands.instant
import dev.nextftc.robot.Mechanism
import org.firstinspires.ftc.teamcode.util.Hardware
import kotlin.math.sign

class Intake : Mechanism{
    private val intake = Hardware.motor("intake")

    val on = instant { intake.throttle = 1.0 }.requiring(intake)
    val off = instant { intake.throttle = 0.0 }.requiring(intake)
    val reverse = instant { intake.throttle = -1.0 }.requiring(intake)
    fun manual(throttle: () -> Float) = infinite { intake.throttle = throttle().toDouble().sign }.requiring(intake)
}