package org.firstinspires.ftc.teamcode.opModes.teleop

import com.pedropathing.ivy.Scheduler.schedule
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.util.Robot

@NextTeleop
class TestTeleop(private val robot: Robot) : NextOpMode(robot) {
    override fun start() {
        val gp1 = CommandGamepad(gamepad1)
        val gp2 = CommandGamepad(gamepad2)

        schedule(robot.drivetrain.manual(gamepad1))

        gp2.rightStickY.isBetween(-0.01..0.01).whileFalse(robot.intake.manual { -gp2.rightStickY.value })
    }
}