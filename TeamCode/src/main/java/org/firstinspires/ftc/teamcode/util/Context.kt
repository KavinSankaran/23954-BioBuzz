package org.firstinspires.ftc.teamcode.util

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.OpMode

class Context(opMode: OpMode) {
    val telemetry = MultipleTelemetry(
        opMode.telemetry,
        FtcDashboard.getInstance().telemetry
    )
}