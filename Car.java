import java.awt.*;

public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double[] coordinates = new double[]{x,y};
    private int direction = 0; // Direction in which the car is pointing at start.

    //Might be public, change later
    protected Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y  = y;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public int getDirection(){
        return direction;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getX() {
        return x;
    }

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

    public void turnLeft() {
        direction--;
        if(direction == -1) {
            direction = 3;
        }

    }

    public void turnRight() {
        direction++;
        if(direction % 4 == 0) {
            direction = 0;
        }

    }
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
                incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }
}

