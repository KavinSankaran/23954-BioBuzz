package org.firstinspires.ftc.teamcode.opModes.teleop

import dev.nextftc.robot.opmode.NextTeleop
import org.firstinspires.ftc.teamcode.util.CommandOpMode

@NextTeleop(name = "RobotCentricTeleop", group = "teleop")
class RobotCentric : CommandOpMode() {
    override fun loop() {
        super.loop()

        drivetrain.robot(gamepad1)
    }
}