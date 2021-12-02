import java.awt.*;

public class Scania extends Truck {

    private double angle;
    private Truck platform;

    public Scania(double currentspeed, double x, double y){
        super(2,300, Color.BLUE, "Scania", currentspeed, x, y);
        this.angle = 0;
    }

    public void increasePlatform(double num) {
        platform.IncreasePlatform(num);
    }

    public void decreasePlatform(double num){
        platform.DecreasePlatform(num);
    }


    @Override
    public void startEngine(){
        if(this.angle==0){
            setCurrentSpeed(0.1);
        }
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
