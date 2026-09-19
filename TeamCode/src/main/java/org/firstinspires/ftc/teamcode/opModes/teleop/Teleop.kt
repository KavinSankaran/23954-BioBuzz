package org.firstinspires.ftc.teamcode.opModes.teleop

import com.pedropathing.ivy.Scheduler.schedule
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.IvyOpMode
import kotlin.math.abs

@TeleOp(name = "Teleop")
class Teleop : IvyOpMode() {
    override fun loop() {
        runOnLoop {
            schedule(drivetrain.robot(gamepad1))

            if (abs(gamepad2.right_stick_y) > 0.01) intake.manual { -gamepad2.right_stick_y }.schedule()
        }
    }
}