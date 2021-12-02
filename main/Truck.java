import java.awt.*;

public abstract class Truck extends Vehicle {

    private double angle;
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
        this.angle=0;
    }

    public void IncreasePlatform(double num){
        if(getCurrentSpeed() == 0 && num > this.angle && num < 70){
            this.angle = num;
        }
        else if (angle < 0 || angle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
    }

    public void DecreasePlatform(double num){
        if(getCurrentSpeed() == 0 && num < this.angle && num >= 0){
            this.angle = num;
        }
        else if (angle < 0 || angle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
    }
}
