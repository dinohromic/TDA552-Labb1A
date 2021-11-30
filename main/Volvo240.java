import java.awt.*;

/**
 * A class that represents the car model Volvo 240
 * It is a subclass to Car
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Class constructor
     * @param currentSpeed current speed of the car when created
     * @param x x position of the car
     * @param y y position of the car
     */
    public Volvo240(double currentSpeed, double x, double y ){
        super(4, 100, Color.black, "Volvo240", currentSpeed, x, y);
        stopEngine();
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }



}
