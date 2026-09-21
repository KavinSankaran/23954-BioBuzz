package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.mechanisms.Hood
import org.firstinspires.ftc.teamcode.util.mechanisms.Shooter

@TeleOp(name = "ShooterTuning", group = "tuning")
class ShooterTuning : OpMode() {
    private val shooter = Shooter()
    private val hood = Hood()

    override fun init() {}

    override fun loop() {
        shooter.periodic()
        hood.periodic()
    }

}