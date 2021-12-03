import java.awt.*;

/**
 * A class Vehicle that implements the interface IMovable.
 * It represents a generalization of attributes for objects of the type vehicle.
 */
public abstract class Vehicle implements IMovable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double[] coordinates = new double[]{x,y};
    private int direction = 0; // Direction in which the car is pointing at start.

    /**
     * Class constructor
     * @param nrDoors Amount of doors on the Vehicle
     * @param enginePower The amount of enginepower the Vehicle has
     * @param color Color of the Vehicle
     * @param modelName Name of the Vehicle
     * @param currentSpeed current speed of the Vehicle when created
     * @param x position of Vehicle when created
     * @param y position of Vehicle when created
     */
    //Might be public, change later
    protected Vehicle(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        if (nrDoors<=0){
            throw new ArithmeticException("Can't have a car with zero or less doors!");
        }
        else{
            this.nrDoors=nrDoors;
        }
        if (enginePower<=0){
            throw new ArithmeticException("Can't have negative engine power");
        }
        else{
            this.enginePower = enginePower;
        }
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y  = y;
    }

    /**
     * Method that gets amount of doors
     * @return amount of doors on the Vehicle.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Method that current returns direction of Vehicle
     * (0=up,1=right,2=down,3=left)
     * @return current direction of Vehicle
     */
    public int getDirection(){
        return direction;
    }

    /**
     * Method that returns the engine power of the Vehicle
     * @return engine power of the Vehicle
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Gets current speed of the Vehicle
     * @return the current speed of the Vehicle
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * A method that gives the Vehicle a specified speed
     * @param currentSpeed is the speed given to the Vehicle
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Gets the color of the Vehicle
     * @return the color of the Vehicle
     */
    public Color getColor(){
        return color;
    }

    /**
     * A method to set the Vehicle color
     * @param clr is the color we want
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * A method that starts the Vehicle and sets the current speed of the Vehicle to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * A method that stops the engine and sets the current speed to zero
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Gets the x position of the Vehicle
     * @return x position
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y position of the Vehicle
     * @return y position
     */
    public double getY() {
        return y;
    }


    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * A method that moves the Vehicle in a certain direction
     * The method also decides how far the Vehicle travels with the current speed
     * @param currentSpeed The current speed of the Vehicle
     */

    @Override
    public void move (double currentSpeed) {

        switch (direction) {
            case 0:
                this.y -= currentSpeed;
                coordinates[1] = this.y;
                break;
            case 1:
                this.x += currentSpeed;
                coordinates[0] = this.x;
                break;
            case 2:
                this.y += currentSpeed;
                coordinates[1] = this.y;
                break;

            case 3:
                this.x -= currentSpeed;
                coordinates[0] = this.x;
                break;
            default:
                break;
        }

    }

    /**
     * A method that turns the Vehicle left i.e. if the Vehicle is facing 0(up) the new direction will be 3(left)
     */
    public void turnLeft() {
        direction--;
        if(direction == -1) {
            direction = 3;
        }
    }

    /**
     * A method that turns the Vehicle right i.e. if the Vehicle is facing 0(up) the new direction will be 1(right)
     */
    public void turnRight() {
        direction++;
        if(direction % 4 == 0) {
            direction = 0;
        }
    }

    /**
     * A method that increases the speed of the Vehicle by a certain amount
     * @param amount the amount by how much the vehicle is to brake (between 0 and 1).
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
                incrementSpeed(amount);
    }

    /**
     * A method the decreases the speed of the Vehicle by a certain amount.
     * @param amount the amount by how much the vehicle is to brake (between 0 and 1).
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }
}

