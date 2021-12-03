import java.awt.*;
/**
 * A subclass, Truck, with the superclass Vehicle. Creates object with type Truck
 */
public abstract class Truck extends Vehicle {

    private double platformAngle;
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
    protected Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.platformAngle=0;
    }
}
