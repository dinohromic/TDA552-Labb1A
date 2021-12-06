import javax.swing.*;
import java.awt.*;
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
    private Vehicle vehicle;

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
        cc.cars.add(new Saab95(0,10, 110));
        cc.cars.add(new Scania(0, 10, 220));

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
            for (Vehicle vehicle : cars) {
                vehicle.move(vehicle.getCurrentSpeed());
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                insideMap(x, y, vehicle);
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.gas(gas);

        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars){
            vehicle.brake(brake);
        }
    }

    private void insideMap(int x, int y, Vehicle vehicle){
        if((x < 0 || x > 800-100) || (y < 0 || y > 800-300)){
            vehicle.turnLeft();
            vehicle.turnLeft();
        }
    }

    void turnLeft(){
        for(Vehicle vehicle: cars) {
            vehicle.turnLeft();
        }
    }

    void turnRight(){
        for(Vehicle vehicle: cars) {
            vehicle.turnRight();
        }
    }
    void turboOn(Saab95 saab95){
        for(Vehicle vehicle: cars){
            if (vehicle == saab95){
                saab95.setTurboOn();
            }

        }
    }
    void turboOff(Saab95 saab95){
        for(Vehicle vehicle: cars){
            if (vehicle == saab95){
                saab95.setTurboOff();
            }

        }
    }

}

