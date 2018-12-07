package View;

import Controller.CarController;
import Model.CarModel;
import Model.Cars;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Model.Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Model.Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Model.Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        //refreshPoints();
        //checkValidPosition();
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        for (int i = 0; i < CarView.getCars().size(); i++){
            int carSpacing = 100 * i;
            Point currentPos = CarView.getPicPoints().get(i).getCarPoint();
            BufferedImage currentImage = CarView.getPicPoints().get(i).getImage();
            g.drawImage(currentImage,currentPos.x,currentPos.y + carSpacing, null);
        }
        /*g.drawImage(images.get(0), carPoints.get(0).x, carPoints.get(0).y, null);
        g.drawImage(images.get(1), carPoints.get(1).x  , carPoints.get(1).y + 100, null);
        g.drawImage(images.get(2), carPoints.get(2).x  , carPoints.get(2).y + 200, null);*/


    }
}