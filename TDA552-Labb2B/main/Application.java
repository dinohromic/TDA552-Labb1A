import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        CarModel cm = new CarModel();
        CarController cc = new CarController(cm);
        UpdateObserver carView = new CarView("CarView 1.0", cc, cm);
        cm.subscribe(carView);


        // Start a new view and send a reference of self
        final int delay = 50;

        Timer timer = new Timer(delay, new Application.TimerListener(cm));
        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private static class TimerListener implements ActionListener {
        CarModel cm;

        TimerListener(CarModel cm){
            this.cm = cm;
        }

        public void actionPerformed(ActionEvent e){
            cm.actionPerformed();

        }
    }
}
