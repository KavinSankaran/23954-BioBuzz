package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import org.firstinspires.ftc.teamcode.util.Context
import org.firstinspires.ftc.teamcode.util.Hardware

@Config
class Hood(private val context: Context) {
    private val hood = Hardware.servo("hood")

    companion object {
        @JvmField var targetPosition = 0.0
    }

    fun periodic() {
        hood.position = targetPosition
        context.telemetry.addData("Hood Position", targetPosition)
    }
}