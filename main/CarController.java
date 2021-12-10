import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private Vehicle car;

    private CarModel carModel;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 10, 10));
        cc.cars.add(new Saab95(0, 10, 110));
        cc.cars.add(new Scania(0,10, 210));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move(car.getCurrentSpeed());
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                insideMap(x, y, car);
                frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);

        }
    }

    void brake(int amount){
        carModel.brake(amount);

    }

    private void insideMap(int x, int y, Vehicle car){
        if((x < 0 || x > 800-100) || (y < 0 || y > 800-300)){
            car.turnLeft();
            car.turnLeft();
        }
    }

    void turnLeft(){
        carModel.turnLeft();
    }

    void turnRight(){
        carModel.turnRight();

    }
    void turboOn(){
        carModel.turboOn();
    }

    void turboOff(){
        for(Vehicle car: cars){
            if (checkIfItIsSaabClass(car, Saab95.class)){
                ((Saab95) car).setTurboOff();
            }

        }
    }

    void startVehicles(){
        carModel.startVehicles();

    }

    void stopVehicles(){
        carModel.stopVehicles();
    }

    void raiseBedOfScania(double newangle){
        for( Vehicle car: cars) {
            if (checkIfItIsSaabClass(car, Scania.class)){
                ((Scania) car).IncreasePlatform(newangle);
            }
        }

    }

    void lowerBedOfScania(double newangle){
        for( Vehicle car: cars) {
            if (checkIfItIsSaabClass(car, Scania.class)){
                ((Scania) car).DecreasePlatform(newangle);
            }
        }

    }

    private boolean checkIfItIsSaabClass(Vehicle car, Class <? extends Vehicle> T){
        return car.getClass() == T;
    }

}

