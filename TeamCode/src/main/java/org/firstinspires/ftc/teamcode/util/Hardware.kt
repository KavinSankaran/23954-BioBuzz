package org.firstinspires.ftc.teamcode.util

import com.qualcomm.robotcore.hardware.DcMotorEx
import dev.nextftc.hardware.RobotController
import dev.nextftc.hardware.actuators.NextFeedbackCRServo
import dev.nextftc.hardware.actuators.NextServo
import dev.nextftc.hardware.sensors.NextAnalogInput
import dev.nextftc.hardware.sensors.NextColorDistanceSensor
import dev.nextftc.hardware.sensors.NextDigitalSensor
import dev.nextftc.hardware.sensors.NextPinpoint
import dev.nextftc.hardware.webcams.NextLimelight

object Hardware {
    fun motor(name: String): DcMotorEx {
        return RobotController.hardwareMap.get(DcMotorEx::class.java, name)
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