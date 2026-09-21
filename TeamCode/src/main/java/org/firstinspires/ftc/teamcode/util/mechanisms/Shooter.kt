package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import com.pedropathing.ivy.commands.Commands.infinite
import dev.nextftc.control.feedback.PIDCoefficients
import dev.nextftc.control.feedback.PIDController
import dev.nextftc.control.feedforward.SimpleFFCoefficients
import dev.nextftc.control.feedforward.SimpleFeedforward
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry
import org.firstinspires.ftc.teamcode.util.Hardware

@Config
class Shooter : Mechanism {
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

    override fun periodic() {
        val currentVelocity = shooter.encoderVelocity

        feedbackCoefficients.kP = kp
        feedforwardCoefficients.kS = ks
        feedforwardCoefficients.kV = kv

        Telemetry.log("Shooter Velocity", currentVelocity)
        Telemetry.log("Shooter Target", targetVelocity)

        val pid = feedback.calculate(error = targetVelocity - currentVelocity.magnitude)
        val ff = feedforward.calculate(targetVelocity)
        shooter.throttle = pid + ff
    }
}