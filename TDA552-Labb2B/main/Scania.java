import java.awt.*;

public class Scania extends Truck {

    private double platformAngle;


    public Scania(double currentspeed, double x, double y){
        super(2,300, Color.BLUE, "Scania", currentspeed, x, y);
        this.platformAngle = 0;
    }
    /**
     * Increases the angle of the truck platform. Cannot raise platform if the truck is moving or set a new angle
     * to higher than 70 or lower than 0 degrees.
     * @param newAngle a double representing the new angle.
     */
    public void IncreasePlatform(double newAngle){
        if(getCurrentSpeed() == 0 && newAngle > this.platformAngle && newAngle < 70){
            this.platformAngle = newAngle;
        }
        else if (platformAngle < 0 || platformAngle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
    }
    /**
     * Decreases the angle of the truck platform. Cannot lower platform if the truck is moving or set a new angle
     * to higher than 70 or lower than 0 degrees.
     * @param newAngle a double representing the new angle.
     */

    public void DecreasePlatform(double newAngle){
        if(getCurrentSpeed() == 0 && newAngle < this.platformAngle && newAngle >= 0){
            this.platformAngle = newAngle;
        }
        else if (platformAngle < 0 || platformAngle > 70){
            throw new ArithmeticException("Can't use an angle less than 0 or larger than 70!");
        }
        else{
            throw new ArithmeticException("Can't use platform while driving!");
        }
    }

    /**
     * Starts the engine of truck. Unable to start if the platform angle is not 0 degrees. Speed automatically sets to
     * 0.1 when the engine starts.
     */

    @Override
    public void startEngine(){
        if(this.platformAngle ==0){
            setCurrentSpeed(0.1);
        }
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
