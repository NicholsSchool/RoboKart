package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class KartDriver{
    //declaring variables, for tweaking use sensitivity and top speed
    public DcMotor redMotor , blueMotor, greenMotor, yellowMotor;
    public RevBlinkinLedDriver blinkin = null;
    RevBlinkinLedDriver.BlinkinPattern pattern;
    ColorSensor colorSensor = null;
    double topSpeed = 0.6;
    double sensitivity = 0.4;
    double acceleration = 0.01;
    double accelOutput = 0.0;

    HardwareMap hwMap = null;

    private ElapsedTime time = new ElapsedTime();

    public void xDriveHardwareMap(){
    }
    public void init( HardwareMap ahwMap ) 
    {
        // Save reference to Hardware map
        HardwareMap hwMap = ahwMap;  
        
        //get motors from hardwaremap
        //set motor directions and zero power to float
    }
        //default move method 
        public void move(double forward, double strafe, double turn, double power){
            //define powers
            //set powers to motors
        }
        //takes status and makes lights those colors
        public void colorToLights(int status){
        if(status == 0){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.WHITE);
        }
        if(status == 1){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        }
        if(status == 2){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
        }
        if(status == 3){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
        }
        if(status == 4){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
        }
        if(status == 5){
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.VIOLET);
        }
    }
    //detects what color you are on
    //you will need to calibrate these values for your color sensor
    public int status(int red, int green, int blue){
        // (0 none) (1 red) (2 blue) (3 green) (4 yellow) (5 purple)
        int status = 0;
        if((red > blue && red > green) && red > 300){
            status = 1;
        }
        if((red < blue && blue > green)&& blue > 500){
            status = 2;
        }
        if((green > blue && red < green)&& green > 250 && red < blue && green < 500){
            status = 3;
        }
        if((green > blue && red > blue)&& red > 450 && green > 750){
            status = 4;
        }
        if(red > 400 && blue > 400 && green > 400 && green < 550 && blue < 550 && red < 550){
            status = 5;
        }
        
        return status;
        
    }    
    
    public double accel(double input){
    if(runtime.seconds() > 0.1){
        accelOutput = (accelOutput + acceleration) * input;
        runtime.reset();
    }
    return accelOutput;
}

}