package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import dev.nextftc.control.feedback.PIDCoefficients
import dev.nextftc.control.feedback.PIDController
import dev.nextftc.control.feedforward.SimpleFFCoefficients
import dev.nextftc.control.feedforward.SimpleFeedforward
import org.firstinspires.ftc.teamcode.util.Context
import org.firstinspires.ftc.teamcode.util.Hardware

@Config
class Shooter(private val context: Context) {
    private val shooter = Hardware.motor("shooter")

    private val feedbackCoefficients = PIDCoefficients(kp)
    private val feedback = PIDController(feedbackCoefficients)
    private val feedforwardCoefficients = SimpleFFCoefficients(ks, kv)
    private val feedforward = SimpleFeedforward(feedforwardCoefficients)

    companion object {
        @JvmField var kp = 0.0
        @JvmField var kv = 0.0
        @JvmField var ks = 0.0
        @JvmField var targetVelocity = 0.0
    }

    fun periodic() {
        val currentVelocity = shooter.velocity

        feedbackCoefficients.kP = kp
        feedforwardCoefficients.kS = ks
        feedforwardCoefficients.kV = kv

        context.telemetry.addData("Shooter Velocity", currentVelocity)
        context.telemetry.addData("Shooter Target", targetVelocity)

        val pid = feedback.calculate(error = targetVelocity - currentVelocity)
        val ff = feedforward.calculate(targetVelocity)

        shooter.power = pid + ff
    }
}