import java.awt.*;

public class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private int x = 0;
    private int y = 0;
    private double[] coordinates = new double[]{x,y};
    private int direction = 0; // Direction in which the car is pointing at start.

    //Might be public, change later
    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }


    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
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

    @Override
    public void turnLeft() {
        direction--;
        if(direction % 4 == 3) {
            direction = 3;
        }

    }

    @Override
    public void turnRight() {
        direction++;
        if(direction % 4 == 0) {
            direction = 0;
        }

    }
}
