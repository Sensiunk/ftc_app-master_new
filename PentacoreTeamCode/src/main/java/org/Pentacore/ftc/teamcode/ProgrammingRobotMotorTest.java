package org.Pentacore.ftc.teamcode;

/**
 * Created by snoqu on 5/27/2017.
 */

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.util.Range;

        import static com.qualcomm.robotcore.util.Range.*;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="ManjeshTeleOp",group="Iterative Opmode")

public class ProgrammingRobotMotorTest extends OpMode{

    private DcMotor motorRight;
    private DcMotor motorLeft;

    public void init() {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        float left;
        float right;

        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;


        right = clip(right, -1, 1);
        left = clip(left, -1, 1);

        right = (float)scaleInput(right);
        left =  (float)scaleInput(left);

        motorRight.setPower(right);
        motorLeft.setPower(left);
    }

    double scaleInput(double dVal)  {

        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        int index = (int) (dVal * 16.0);

        if (index < 0) {
            index = -index;
        }

        if (index > 16) {
            index = 16;
        }

        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;

    }
}