import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

public class CarModel{
    private ArrayList<Vehicle> cars;
    private ArrayList<BufferedImage> VehicleImages;
    private ArrayList<Point> VehiclePoints;
    private ArrayList<UpdateObserver> observerArrayList = new ArrayList<>();



    public CarModel() {
        cars = new ArrayList<>();
        VehicleImages = new ArrayList<>();
        VehiclePoints = new ArrayList<>();
        initiateCars();
    }

    public void subscribe(UpdateObserver updateObserver){
        observerArrayList.add(updateObserver);
    }

    public void actionPerformed() {
        for (Vehicle car : cars) {
            car.move(car.getCurrentSpeed());

            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());

            insideMap(x, y, car);
            moveit(x, y, cars.indexOf(car));
            // repaint() calls the paintComponent method of the panel
            //frame.drawPanel.repaint();
            for(UpdateObserver o : observerArrayList){
                o.update();
            }
        }
    }

    private void moveit(int x, int y, int indexOfCars){
        Point p = VehiclePoints.get(indexOfCars);
        p.x = x;
        p.y = y;
    }

    private void insideMap(int x, int y, Vehicle car){
        if((x < 0 || x > 800-100) || (y < 0 || y > 800-300)){
            car.turnLeft();
            car.turnLeft();
        }
    }

    private void initiateCars(){
        this.cars.add(CarFactory.MakeVolvo(10,100));
        this.cars.add(CarFactory.MakeSaab(10,200));
        this.cars.add(CarFactory.MakeScania(10,300));
        for (Vehicle car : cars) {

            Point p = new Point((int) car.getX(), (int) car.getY());
            VehiclePoints.add(p);

            try {
                VehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg")));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Point> GetCarPoint() {
        ArrayList<Point> PointList = new ArrayList<>();
        for(Point p: VehiclePoints){
            PointList.add(p);
        }
        return PointList;

    }

    public ArrayList<BufferedImage> GetCarImages(){
        ArrayList<BufferedImage> CarImage = new ArrayList<>();
        for(BufferedImage images : VehicleImages){
            CarImage.add(images);
        }
        return CarImage;
    }


    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);

        }
    }

    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars){
            car.brake(brake);
        }
    }

    public void turnLeft(){
        for(Vehicle car: cars) {
            car.turnLeft();
        }
    }

    public void turnRight(){
        for(Vehicle car: cars) {
            car.turnRight();
        }
    }
    public void turboOn(){
        for(Vehicle car: cars){
            if (checkClass(car, Saab95.class)){
                ((Saab95) car).setTurboOn();
            }

        }
    }
    public void turboOff(){
        for(Vehicle car: cars){
            if (checkClass(car, Saab95.class)){
                ((Saab95) car).setTurboOff();
            }

        }
    }

    public void startVehicles(){
        for(Vehicle car: cars){
            car.startEngine();
        }
    }

    public void stopVehicles(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
    }

    public void raiseBedOfScania(double newangle){
        for( Vehicle car: cars) {
            if (checkClass(car, Scania.class)){
                ((Scania) car).IncreasePlatform(newangle);
            }
        }

    }

    public void lowerBedOfScania(double newangle){
        for(Vehicle car: cars) {
            if (checkClass(car, Scania.class)){
                ((Scania) car).DecreasePlatform(newangle);
            }
        }

    }

    private boolean checkClass(Vehicle car, Class <? extends Vehicle> T){
        return car.getClass() == T;
    }

}


