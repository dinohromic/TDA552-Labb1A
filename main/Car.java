import java.awt.*;

public abstract class Car extends Vehicle{
    /**
     * Class constructor
     *
     * @param nrDoors      Amount of doors on the car
     * @param enginePower  The amount of engine power the has
     * @param color        Color of the car
     * @param modelName    Name of the car
     * @param currentSpeed current speed of the car when created
     * @param x            position of car when created
     * @param y            position of car when created
     */
    protected Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
    }
}
