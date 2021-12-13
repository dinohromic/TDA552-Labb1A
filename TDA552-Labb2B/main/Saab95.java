import java.awt.*;

/**
 * A class that represents the car model Saab95
 * It is a subclass to Car
 */
public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Class constructor
     * @param currentSpeed current speed of the car when created
     * @param x x position
     * @param y y position
     * Has turbo boolean that can increase the speed factor
     */
    public Saab95(double currentSpeed, double x, double y){
        super(2, 125, Color.red, "Saab95", currentSpeed, x, y);
        turboOn = false;
        stopEngine();
    }

    /**
     * Turns the turbo boolean ON
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turns the turbo boolean OFF
     */
    public void setTurboOff(){
        turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
