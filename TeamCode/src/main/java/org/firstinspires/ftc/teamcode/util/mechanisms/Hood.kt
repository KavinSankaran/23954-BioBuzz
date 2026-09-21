package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import com.pedropathing.ivy.commands.Commands.infinite
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry
import org.firstinspires.ftc.teamcode.util.Hardware

@Config
class Hood : Mechanism {
    private val hood = Hardware.servo("hood")

    companion object {
        @JvmField var targetPosition = 0.0
    }

    override fun periodic() {
        hood.position = targetPosition
        Telemetry.log("Hood Position", targetPosition)    }
}