import java.util.ArrayList;
import java.util.List;

public class Workshops<W extends Car>{
    private int maxCars;
    private List<W> carsInWorkshop = new ArrayList<>(maxCars);


    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    public int amountOfCarsInWorkshop(){
        return carsInWorkshop.size();
    }

    public <T extends W> void setCarsInWorkshop(T car) {
        if(!numberOfCarsInWorkshop() && amountOfCarsInWorkshop() < maxCars)
            carsInWorkshop.add(car);

    }

    public <T extends W> void removeCarsInWorkshop(T car) {
        carsInWorkshop.remove(car);
    }

    //Maybe remove T and W in this method??
    public <T extends W> boolean numberOfCarsInWorkshop(){
        for(Car car: carsInWorkshop) {
            if (amountOfCarsInWorkshop() <= maxCars ) {
                return true;
            }
        }
        return false;
    }
}
