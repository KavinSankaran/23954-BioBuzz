package org.firstinspires.ftc.teamcode.util

import com.pedropathing.ivy.Scheduler
import com.pedropathing.ivy.Scheduler.schedule
import com.qualcomm.hardware.lynx.LynxModule
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.util.ElapsedTime
import org.firstinspires.ftc.teamcode.util.mechanisms.*

abstract class IvyOpMode : OpMode() {
    val context = Context(this)
    val intake = Intake(context)
    val drivetrain = Drivetrain(context)
    val shooter = Shooter(context)
    val hood = Hood(context)

    private val hubs : List<LynxModule> by lazy {  hardwareMap.getAll(LynxModule::class.java) }
    private val loopTimer = ElapsedTime(ElapsedTime.Resolution.MILLISECONDS)

    override fun init() {
        Scheduler.reset()

        schedule(
            shooter.periodic(),
            hood.periodic()
        )

        hubs.forEach { it.bulkCachingMode = LynxModule.BulkCachingMode.MANUAL }
        loopTimer.reset()
    }

    protected fun runOnLoop(runnable: Runnable){
        context.telemetry.addData("Loop Times", loopTimer.milliseconds())
        loopTimer.reset()

        hubs.forEach(LynxModule::clearBulkCache)

        runnable.run()
        Scheduler.execute()

        context.telemetry.update()
    }
}