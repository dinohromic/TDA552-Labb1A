import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a car workshop. Only accepts objects of type Car.
 * @param <W> type W extends Car
 */
//we use parametrized types because otherwise we have to use methods for every type of car we accept in the workshop.
//W is the type we accept, and it inherits type Car. W is parametrized over type Car.
public class Workshops<W extends Car>{
    private int maxCars;
    private List<W> carsInWorkshop = new ArrayList<>(maxCars);


    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    /**
     * Returns the current amount of cars in the workshop
     * @return carsInWorkshop
     */
    public int amountOfCarsInWorkshop(){
        return carsInWorkshop.size();
    }

    /**
     * Adds cars to the workshop, if the max capacity is not reached.
     * @param car object of type car
     */
    public void addCarsToWorkshop(W car) {
        if(amountOfCarsInWorkshop() < maxCars)
            carsInWorkshop.add(car);
    }

    /**
     * Removes cars from the workshop.
     * @param car object of type car
     */
    public void removeCarsInWorkshop(W car) {
        carsInWorkshop.remove(car);
    }

    /**
     * Returns a boolean true or false, indicating if there are any cars in the workshop.
     * @return true
     */
    public boolean isCarInWorkshop(){
        for(Car car: carsInWorkshop) {
            if (amountOfCarsInWorkshop() <= maxCars ) {
                return true;
            }
        }
        return false;
    }
}