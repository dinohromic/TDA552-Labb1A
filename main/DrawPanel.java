import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private Vehicle car;

    private ArrayList<BufferedImage> VehicleImages = new ArrayList<>();
    private ArrayList<Point> VehiclePoints = new ArrayList<>();

    // Just a single image, TODO: Generalize
    

    // To keep track of a single cars position

    

    // TODO: Make this general for all cars
    void moveit(int x, int y, int indexOfCars){
        Point p = VehiclePoints.get(indexOfCars);
        p.x = x;
        p.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        // Print an error message in case file is not found with a try/catch block
        for(Vehicle car: cars){

            Point p = new Point((int) car.getX(), (int) car.getY());
            VehiclePoints.add(p);

            try {
                VehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg")));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage carImage: VehicleImages)
        g.drawImage(carImage, VehiclePoints.get(VehicleImages.indexOf(carImage)).x, VehiclePoints.get(VehicleImages.indexOf(carImage)).y, null);



    }
}
