package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import com.acmerobotics.dashboard.config.Config
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.TuningOpMode
import org.firstinspires.ftc.teamcode.util.mechanisms.Hood
import org.firstinspires.ftc.teamcode.util.mechanisms.Shooter

@Config
@TeleOp(name = "ShooterTuning", group = "tuning")
class ShooterTuning : TuningOpMode() {
    lateinit var shooter: Shooter
    lateinit var hood: Hood

    override fun init() {
        super.init()

        shooter = Shooter(context)
        hood = Hood(context)
    }

    override fun loop() {
        super.loop()
        shooter.periodic()
        hood.periodic()
    }

}