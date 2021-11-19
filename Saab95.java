import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(double currentSpeed, double x, double y){
        super(2, 125, Color.red, "Saab95", currentSpeed, x, y);
        turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }





}
