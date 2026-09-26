package org.firstinspires.ftc.teamcode.util

import com.pedropathing.ivy.Scheduler
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import dev.nextftc.robot.Telemetry
import org.firstinspires.ftc.teamcode.util.mechanisms.Drivetrain

abstract class CommandOpMode : OpMode() {
    lateinit var context: Context
    lateinit var drivetrain: Drivetrain

    override fun init() {
        context = Context(this)
        drivetrain = Drivetrain()

        Scheduler.reset()
    }

    override fun init_loop() {
        context.telemetry.update()
    }

    override fun loop() {
        Scheduler.execute()
        context.telemetry.update()
    }
}