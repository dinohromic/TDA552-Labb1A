import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(double currentSpeed, double x, double y){
        super(4, 100, Color.black, "Volvo240", currentSpeed, x, y);
        stopEngine();
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}
