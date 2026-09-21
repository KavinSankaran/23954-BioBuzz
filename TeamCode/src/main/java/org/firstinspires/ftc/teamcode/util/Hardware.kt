package org.firstinspires.ftc.teamcode.util

import dev.nextftc.hardware.actuators.NextFeedbackCRServo
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.hardware.actuators.NextServo
import dev.nextftc.hardware.sensors.NextAnalogInput
import dev.nextftc.hardware.sensors.NextColorDistanceSensor
import dev.nextftc.hardware.sensors.NextDigitalSensor
import dev.nextftc.hardware.sensors.NextPinpoint
import dev.nextftc.hardware.webcams.NextLimelight
import dev.nextftc.units.measuretypes.Angle
import dev.nextftc.units.rotations

object Hardware {
    fun motor(name: String, anglePerCount: Angle = 1.0.rotations): NextMotor {
        return NextMotor(name, anglePerCount)
    }

    fun servo(name: String): NextServo {
        return NextServo(name)
    }

    fun feedbackServo(name: String, analogInput: NextAnalogInput): NextFeedbackCRServo {
        return NextFeedbackCRServo(name, analogInput)
    }

    fun color(name: String): NextColorDistanceSensor {
        return NextColorDistanceSensor(name)
    }

    fun digital(name: String): NextDigitalSensor {
        return NextDigitalSensor(name)
    }

    fun pinpoint(name: String): NextPinpoint {
        return NextPinpoint(name)
    }

    fun limelight(name: String): NextLimelight {
        return NextLimelight(name)
    }
}