package org.firstinspires.ftc.teamcode.util

import com.pedropathing.ivy.Command
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import kotlin.math.sign

class Intake : Mechanism {
    private val intake = NextMotor("intake")

    val on = instant { intake.throttle = 1.0 }
    val off = instant { intake.throttle = 0.0 }
    val reverse = instant { intake.throttle = -1.0 }
    fun manual(throttle: () -> Double) = infinite { intake.throttle = throttle().sign }

    override val defaultCommand: Command
        get() = super.defaultCommand
}