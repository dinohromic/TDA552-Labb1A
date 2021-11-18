
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
    void incSpeedSaab(){
        Saab95 saab95 = new Saab95(0,0,0);
        saab95.startEngine();
        saab95.setTurboOn();
        saab95.incrementSpeed(1);
        assertEquals(1.725, saab95.getCurrentSpeed());
    }

    @Test
    void decSpeedSaab(){

    }

    @Test
    void speedFactorSaab(){

    }

    @Test
    void incSpeedVolvo(){

    }

    @Test
    void decSpeedVolvo(){

    }

    @Test
    void speedFactorVolvo(){

    }


}