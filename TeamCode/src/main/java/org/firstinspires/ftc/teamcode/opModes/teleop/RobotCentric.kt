package org.firstinspires.ftc.teamcode.opModes.teleop

import com.pedropathing.ivy.Scheduler.schedule
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import org.firstinspires.ftc.teamcode.util.mechanisms.Robot

@NextTeleop(name = "RobotCentricTeleop", group = "teleop")
class RobotCentric(private val robot: Robot) : NextOpMode(robot) {
    override fun start() {
        schedule(robot.drivetrain.robot(gamepad1))
    }
}