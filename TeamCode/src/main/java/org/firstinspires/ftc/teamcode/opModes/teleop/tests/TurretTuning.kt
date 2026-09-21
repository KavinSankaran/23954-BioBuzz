package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.mechanisms.Turret

@TeleOp(name = "TurretTuning")
class TurretTuning : OpMode() {
    private val turret = Turret()

    override fun init() {}

    override fun loop() {
        turret.periodic()
    }
}