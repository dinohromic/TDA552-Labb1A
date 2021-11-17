
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TestCar extends Car{


    protected TestCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    @Test
    void car_turns_left() {

    }

    @Test
    void car_turns_right(){

    }

    @Test
    void car_moves(){

    }
}

class TestSaab extends Saab95{

    @Test
    void incSpeed(){

    }

    @Test
    void decSpeed(){

    }

    @Test
    void speedFactor(){

    }
}

class TestVolvo extends Volvo240{

    @Test
    void incSpeed(){

    }

    @Test
    void decSpeed(){

    }

    @Test
    void speedFactor(){

    }
}