package Controller;

import Model.*;
import View.CarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    CarView frame = new CarView("CarSim 1.0", this);

    CarModel model;

    // A list of cars, modify if needed
    private final static ArrayList<Cars> cars = new ArrayList<>();

    //methods:
    public void gas(int amount) {
        model.gas(amount);
    }
    public void brake(int amount) {
        model.brake(amount);
    }
    public void startEngine(){
        model.startEngine();
    }
    public void stopEngine(){
        model.stopEngine();
    }
    public void tiltDown(){
        model.tiltDown();
    }
    public void tiltUp(){
        model.tiltUp();
    }
    public void setTurboOn(){
        model.setTurboOn();
    }
    public void setTurboOff(){
        model.setTurboOff();
    }
    public void addCar(Cars car) {
        cars.add(car);
    }

    public void moveAllCarsRepaint() {
        int count = 0;
        for (Cars car : CarModel.getCars()) {
            car.move();
            int x = (int) Math.round(car.getPosX());
            int y = (int) Math.round(car.getPosY());
            frame.moveit(x, y, count);
            // repaint() calls the paintComponent method of the panel
            frame.repaint();
            count++;
        }
    }

}
