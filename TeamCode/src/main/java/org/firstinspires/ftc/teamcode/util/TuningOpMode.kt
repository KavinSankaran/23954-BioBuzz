package org.firstinspires.ftc.teamcode.util

import com.pedropathing.ivy.Scheduler
import com.qualcomm.robotcore.eventloop.opmode.OpMode

abstract class TuningOpMode : OpMode() {
    lateinit var context: Context

    override fun init() {
        Scheduler.reset()

        context = Context(this)
    }

    override fun init_loop() {
        context.telemetry.update()
    }

    override fun loop() {
        Scheduler.execute()
        context.telemetry.update()
    }
}