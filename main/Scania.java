import java.awt.*;

public class Scania extends Truck {

    private double angle;

    public Scania(double currentspeed, double x, double y){
        super(2,300, Color.BLUE, "Scania", currentspeed, x, y);
        this.angle = 0;
    }

    public void IncreasePlatform(double num){
        if(getCurrentSpeed() == 0 && num > this.angle && num < 70){
            this.angle = num;
        }
        else if (angle < 0 || angle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
    }

    public void DecreasePlatform(double num){
        if(getCurrentSpeed() == 0 && num < this.angle && num >= 0){
            this.angle = num;
        }
        else if (angle < 0 || angle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
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
