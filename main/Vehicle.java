import java.awt.*;

/**
 * object of type car
 * It represents a generalization of attributes for objects of the type car
 */
public abstract class Vehicle implements Movable{
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
     * @param nrDoors Amount of doors on the car
     * @param enginePower The amount of enginepower the has
     * @param color Color of the car
     * @param modelName Name of the car
     * @param currentSpeed current speed of the car when created
     * @param x position of car when created
     * @param y position of car when created
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
     * @return amount of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Method that current returns direction of car
     * (0=up,1=right,2=down,3=left)
     * @return current direction of car
     */
    public int getDirection(){
        return direction;
    }

    /**
     * Method that returns the engine power of the car
     * @return engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Gets current speed of the car
     * @return the current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * A method that gives the car a specified speed
     * @param currentSpeed is the speed given to the car
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Gets the color of the car
     * @return the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * A method to set the cars color
     * @param clr is the color we want
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * A method that starts the car and sets the current speed of the car to 0.1
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
     * Gets the x position of the car
     * @return x position
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y position of the car
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
     * A method that moves the car in a certain direction
     * The method also decides how far the car travels with the current speed
     * @param currentSpeed The current speed of the car
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
     * A method that turns the car left i.e. if the car is facing 0(up) the new direction will be 3(left)
     */
    public void turnLeft() {
        direction--;
        if(direction == -1) {
            direction = 3;
        }

    }

    /**
     * A method that turns the car right i.e. if the car is facing 0(up) the new direction will be 1(right)
     */
    public void turnRight() {
        direction++;
        if(direction % 4 == 0) {
            direction = 0;
        }

    }

    /**
     * A method that increases the speed of the car by a certain amount
     * The amount is between 0 and 1
     * @param amount
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
                incrementSpeed(amount);
    }

    /**
     * A method the decreases the speed of the car by a certain amount
     * The amount is between 0 and 1
     * @param amount
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }
}

