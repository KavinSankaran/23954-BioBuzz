package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import dev.nextftc.control.feedback.PIDCoefficients
import dev.nextftc.control.feedback.PIDController
import dev.nextftc.hardware.sensors.NextAnalogInput
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry
import dev.nextftc.units.degrees
import dev.nextftc.units.measuretypes.Angle
import org.firstinspires.ftc.teamcode.util.Hardware

@Config
class Turret : Mechanism{
    private val analogInput = NextAnalogInput("analogInput")
    private val servo1 = Hardware.feedbackServo("servo1", analogInput)
    private val servo2 = Hardware.feedbackServo("servo2", analogInput)

    val feedbackCoefficients = PIDCoefficients(kp, 0.0, kd)
    val feedback = PIDController(feedbackCoefficients)

    companion object {
        @JvmField var targetAngle = 0.0.degrees

        @JvmField var kp = 0.0
        @JvmField var kd = 0.0

        @JvmField var minAngle = (-180.0)
        @JvmField var maxAngle = 180.0
        @JvmField var angleOffset = 0.0
    }

    var currentAngle = 0.0.degrees
        private set

    fun setTargetAngle(angle: Angle) {
        targetAngle = angle.magnitude.coerceIn(minAngle..maxAngle).degrees
    }

    override fun periodic() {
        val voltage = analogInput.rawVoltage
        val rawAngle = ((voltage / 3.3) * 360).magnitude
        currentAngle = (rawAngle - 180 + angleOffset).degrees

        feedbackCoefficients.kP = kp
        feedbackCoefficients.kD = kd

        val pid = feedback.calculate(error = targetAngle.magnitude - currentAngle.magnitude)

        servo1.power = pid
        servo2.power = pid

        Telemetry.log("Turret Voltage", voltage)
        Telemetry.log("Current Angle", currentAngle)
        Telemetry.log("Target Angle", targetAngle)
    }
}