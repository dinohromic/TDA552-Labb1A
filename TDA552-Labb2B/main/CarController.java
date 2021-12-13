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
    private CarModel carModel;

    public CarController(CarModel cm){
        this.carModel = cm;
    }

    // Controllers
    void gas(int amount) {
        carModel.gas(amount);

    }

    void brake(int amount){
        carModel.brake(amount);

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
        carModel.turboOff();

    }

    void startVehicles(){
        carModel.startVehicles();

    }

    void stopVehicles(){
        carModel.stopVehicles();

    }

    void raiseBedOfScania(double NewAngle){
        carModel.raiseBedOfScania(NewAngle);

    }

    void lowerBedOfScania(double NewAngle){
        carModel.lowerBedOfScania(NewAngle);

    }


}

