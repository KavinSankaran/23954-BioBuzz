package org.firstinspires.ftc.teamcode.util

import com.acmerobotics.dashboard.config.Config
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.hardware.actuators.NextServo
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry
import dev.nextftc.units.degrees
import dev.nextftc.units.degreesPerSecond
import dev.nextftc.units.measuretypes.AngularVelocity

@Config
class Shooter : Mechanism {
    private val shooter = NextMotor("shooter", (360.0 / TICKS_PER_REV).degrees).apply {
        velocityConstants.kP = kp
        velocityConstants.kV = kv
        velocityConstants.kS = ks
    }

    private val hood = NextServo("hood")

    val off = instant { shooter.setVelocitySetpoint(ticksToDegrees(0.0)) }
    fun updateHoodPosition() = infinite { hood.position = hoodAngle }
    fun updateShooterVelocity() = infinite { shooter.setVelocitySetpoint(ticksToDegrees(target)) }

    fun ticksToDegrees(ticks: Double): AngularVelocity {
        return (ticks * (360.0 / TICKS_PER_REV)).degreesPerSecond
    }

    companion object {
        const val TICKS_PER_REV = 28.0

        @JvmField var kp = 0.0
        @JvmField var kv = 0.0
        @JvmField var ks = 0.0
        @JvmField var target = 0.0

        @JvmField var hoodAngle = 0.0
    }

    override fun periodic() {
        Telemetry.log("Shooter Velocity", shooter.encoderVelocity)
        Telemetry.log("Shooter Target", target)
        Telemetry.log("Hood Angle", hood.position)
    }
}