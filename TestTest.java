
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TestCar{

    @Test
    void car_turns_left() {
        Volvo240 volvo240 = new Volvo240(0);
        volvo240.turnLeft();
        assertEquals(3, volvo240.getDirection());


    }

    @Test
    void car_turns_right(){
        Saab95 saab95 = new Saab95(0);
        saab95.turnRight();
        assertEquals(1, saab95.getDirection());

    }

    @Test
    void car_moves(){
        Saab95 saab95 = new Saab95(0);
        saab95.startEngine();
        saab95.move(saab95.currentSpeed);
        assertEquals();



    }

    @Test
    void incSpeedSaab(){

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