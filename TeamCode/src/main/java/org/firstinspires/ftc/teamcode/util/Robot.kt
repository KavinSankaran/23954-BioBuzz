package org.firstinspires.ftc.teamcode.util

import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.NextRobot

class Robot : NextRobot {
    val drivetrain = Drivetrain()
    val intake = Intake()
    val shooter = Shooter()

    override val mechanisms: Set<Mechanism>
        get() = setOf(drivetrain, intake, shooter)
}