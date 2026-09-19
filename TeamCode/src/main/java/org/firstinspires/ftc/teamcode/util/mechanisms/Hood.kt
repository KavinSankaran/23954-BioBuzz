package org.firstinspires.ftc.teamcode.util.mechanisms

import com.acmerobotics.dashboard.config.Config
import com.pedropathing.ivy.commands.Commands.infinite
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.util.Context

@Config
class Hood(context: Context) {
    private val hood by lazy { context.hardwareMap.get(Servo::class.java, "hood") }

    companion object {
        @JvmField var targetPosition = 0.0
    }

    fun periodic() = infinite {
        hood.position = targetPosition
    }
}