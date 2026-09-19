package org.firstinspires.ftc.teamcode.opModes.teleop.tests

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.Context
import org.firstinspires.ftc.teamcode.util.mechanisms.Hood
import org.firstinspires.ftc.teamcode.util.mechanisms.Shooter

@TeleOp(name = "ShooterTuning", group = "tuning")
class ShooterTuning : OpMode() {
    private lateinit var context: Context
    private lateinit var shooter: Shooter
    private lateinit var hood: Hood

    override fun init() {
        context = Context(this)
        shooter = Shooter(context)
        hood = Hood(context)
    }

    override fun loop() {
        shooter.periodic()
        hood.periodic()
    }

}