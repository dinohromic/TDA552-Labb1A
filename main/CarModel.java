import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private ArrayList<Vehicle> cars= new ArrayList<>();

    private CarView frame;


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




    private void insideMap(int x, int y, Vehicle car){
        if((x < 0 || x > 800-100) || (y < 0 || y > 800-300)){
            car.turnLeft();
            car.turnLeft();
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);

        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars){
            car.brake(brake);
        }
    }

    void turnLeft(){
        for(Vehicle car: cars) {
            car.turnLeft();
        }
    }

    void turnRight(){
        for(Vehicle car: cars) {
            car.turnRight();
        }
    }
    void turboOn(){
        for(Vehicle car: cars){
            if (checkIfItIsSaabClass(car, Saab95.class)){
                ((Saab95) car).setTurboOn();
            }

        }
    }
    void turboOff(){
        for(Vehicle car: cars){
            if (checkIfItIsSaabClass(car, Saab95.class)){
                ((Saab95) car).setTurboOff();
            }

        }
    }

    void startVehicles(){
        for(Vehicle car: cars){
            car.startEngine();
        }
    }

    void stopVehicles(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
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
