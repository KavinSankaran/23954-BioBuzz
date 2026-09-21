package org.firstinspires.ftc.teamcode.opModes.teleop

import com.pedropathing.ivy.Scheduler.schedule
import com.pedropathing.ivy.commands.Commands.instant
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.util.mechanisms.Robot

@NextTeleop(name = "FieldCentricTeleop", group = "teleop")
class FieldCentric(private val robot: Robot) : NextOpMode(robot) {
    override fun start() {
        val gp1 = CommandGamepad(gamepad1)

        schedule(robot.drivetrain.field(gamepad1))

        gp1.a.onTrue(instant(robot.drivetrain::resetHeading))
    }
}