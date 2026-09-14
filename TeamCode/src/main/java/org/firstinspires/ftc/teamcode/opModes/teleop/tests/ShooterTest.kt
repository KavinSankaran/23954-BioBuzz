package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.util.Robot

class ShooterTest(private val robot: Robot) : NextOpMode(robot) {
    override fun start() {
        val gp2 = CommandGamepad(gamepad2)

        robot.shooter.updateShooterVelocity().schedule()
        gp2.x.onTrue(robot.shooter.off)
        robot.shooter.updateHoodPosition().schedule()
    }
}