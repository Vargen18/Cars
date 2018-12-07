import Controller.CarController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    private static CarController cc;


    public static void main(String[] args) {
        // Instance of this class
        Application application = new Application();
        cc = new CarController();


        cc.addCar(new Volvo240());
        cc.addCar(new Saab95());
        cc.addCar(new Scania());

        // Start the timer
        application.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener { //Now simply calls a method in CarController, as it doesn't make sense for Application to be pulling the strings of the model.

        public void actionPerformed(ActionEvent e) {
            cc.moveAllCarsRepaint();
        }
    }

}
