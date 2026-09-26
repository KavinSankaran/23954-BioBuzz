package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.TuningOpMode
import org.firstinspires.ftc.teamcode.util.mechanisms.Turret

@TeleOp(name = "TurretTuning")
class TurretTuning : TuningOpMode() {
    lateinit var turret: Turret

    override fun init() {
        super.init()

        turret = Turret(context)
    }

    override fun loop() {
        super.loop()
        turret.periodic()
    }
}