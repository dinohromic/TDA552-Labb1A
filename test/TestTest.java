
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TestCar{

    @Test
    void car_turns_left() {
        // Cars starting direction is always 0 (up). (0=>3=>2=>1)
        Volvo240 volvo240 = new Volvo240(0,0,0);
        volvo240.turnLeft();
        assertEquals(3, volvo240.getDirection());
    }

    @Test
    void car_turns_right(){
        //(0=>1=>2=>3)
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.turnRight();
        assertEquals(1, saab95.getDirection());

    }

    @Test
    void car_moves(){
        Saab95 saab95 = new Saab95(0,1,1);
        saab95.startEngine();
        //StartEngine = currentSpeed = 0.1
        saab95.move(saab95.getCurrentSpeed());
        assertEquals(0.9, saab95.getY());
    }

    @Test
    void incSpeedSaabTurboON(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.startEngine();
        saab95.setTurboOn();
        saab95.incrementSpeed(1);
        assertEquals(1.725, saab95.getCurrentSpeed());
    }

    @Test
    void incSpeedSaabTurboOFF(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.startEngine();
        saab95.setTurboOff();
        saab95.incrementSpeed(1);
        assertEquals(1.35, saab95.getCurrentSpeed());
    }

    @Test
    void decSpeedSaab(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.setCurrentSpeed(10);
        saab95.decrementSpeed(1);
        assertEquals(8.75, saab95.getCurrentSpeed());
    }

    @Test
    void speedFactorSaab(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.speedFactor();
        assertEquals(1.25, saab95.speedFactor());
    }

    @Test
    void incSpeedVolvo(){
        Volvo240 volvo240 = new Volvo240(0,0,0);
        volvo240.startEngine();
        volvo240.incrementSpeed(1);
        assertEquals(1.35, volvo240.getCurrentSpeed());
    }

    @Test
    void decSpeedVolvo(){
        Volvo240 volvo240 = new Volvo240(0,0,0);
        volvo240.setCurrentSpeed(10);
        volvo240.decrementSpeed(1);
        assertEquals(8.75, volvo240.getCurrentSpeed());
    }

    @Test
    void speedFactorVolvo(){
        Volvo240 volvo240 = new Volvo240(0,0,0);
        volvo240.speedFactor();
        assertEquals(1.25, volvo240.speedFactor());

    }

    @Test
    void gasSaab(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.startEngine();
        saab95.gas(1);
        assertEquals(1.35, saab95.getCurrentSpeed());
    }

    @Test
    void breakSaab(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.startEngine();
        saab95.setCurrentSpeed(10);
        saab95.brake(1);
        assertEquals(8.75,saab95.getCurrentSpeed());

    }

    @Test
    void gasScania(){
        Scania scania = new Scania(0, 0, 0);
        scania.startEngine();
        scania.gas(1);
        assertEquals(3.1, scania.getCurrentSpeed());
    }

    @Test
    void speedFactorScania(){
        Scania scania = new Scania(0,0,0);
        scania.speedFactor();
        assertEquals(3.0, scania.speedFactor());
    }


    @Test
    void DistCarsOnTruck(){
        CarTransporter carTransporter = new CarTransporter(0,0,0);
        Saab95 saab95 = new Saab95(0,5,5);
        carTransporter.DistanceOfCar(saab95);
        assertEquals(false, carTransporter.DistanceOfCar(saab95));

    }

    @Test
    void LoadCarsOnTruck(){
        CarTransporter carTransporter = new CarTransporter(0,0,0);
        Saab95 saab95 = new Saab95(0,1,2);
        Volvo240 volvo240 = new Volvo240(0,2,1);
        carTransporter.lowerRamp();
        carTransporter.LoadCars(saab95);
        carTransporter.LoadCars(volvo240);
        carTransporter.UnloadCars(volvo240);
        assertEquals(1, carTransporter.GetAmountOfCarsInStorage());
    }

}