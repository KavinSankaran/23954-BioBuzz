package org.firstinspires.ftc.teamcode.util

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.OpMode

class Context(opMode: OpMode) {
    val hardwareMap = opMode.hardwareMap
    val telemetry = MultipleTelemetry(
        opMode.telemetry,
        FtcDashboard.getInstance().telemetry
    )
}