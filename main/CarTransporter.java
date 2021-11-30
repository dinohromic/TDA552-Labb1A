import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck {

    private boolean ramp;
    private ArrayList<Car> CarTransportList = new ArrayList<>(4);

    /**
     * Class constructor
     * @param currentSpeed current speed of the car when created
     * @param x            position of car when created
     * @param y            position of car when created
     */
    protected CarTransporter(double currentSpeed, double x, double y) {
        super(2, 300, Color.RED, "Car Transporter", currentSpeed, x, y);
        ramp = true;
    }

    public void liftRamp(){
            ramp = true;
    }

    public void lowerRamp(){
            ramp = false;
    }

    public void LoadCars(Car car){
        if(!ramp && getCurrentSpeed() == 0 && DistanceOfCar(car)){
            CarTransportList.add(car);
        }
    }

    public void UnloadCars(){
        int size = CarTransportList.size();
        if(!ramp && size != 0 && getCurrentSpeed() == 0){
            CarTransportList.remove(size-1);
        }
    }

    public int GetAmountOfCarsInStorage(){
        return CarTransportList.size();
    }


    public boolean DistanceOfCar(Car car) {
        double xPos = car.getX() - this.getX();
        double yPos = car.getY() - this.getY();
        return Math.sqrt(Math.pow(xPos, 2) + Math.pow(yPos, 2)) < 4;
    }

    public void move(double currentspeed, CarTransporter carTransporter){
        super.move(currentspeed);
        sameCurrentspeed(currentspeed);
        for (Car car: CarTransportList){
            while (true) {
                if(car.getDirection()== carTransporter.getDirection()){
                    break;
                }
                else{
                    car.turnRight();
                }
            }
        }

    }

    private void sameCurrentspeed(double currentspeed) {

    }


    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
