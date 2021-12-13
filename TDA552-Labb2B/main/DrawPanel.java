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
    private CarModel carM;

    // Initializes the panel and reads the images

    public DrawPanel(int x, int y, CarModel cm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.carM = cm;

    }
    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage carImage: carM.GetCarImages())
        g.drawImage(carImage, carM.GetCarPoint().get(carM.GetCarImages().indexOf(carImage)).x, carM.GetCarPoint().get(carM.GetCarImages().indexOf(carImage)).y, null);



    }
}
