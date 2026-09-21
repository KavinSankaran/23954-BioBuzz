package org.firstinspires.ftc.teamcode.util.mechanisms

import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.util.Hardware

class Robot : NextRobot {
    val drivetrain = Drivetrain()

    override val mechanisms: Set<Mechanism>
        get() = setOf(drivetrain)
}