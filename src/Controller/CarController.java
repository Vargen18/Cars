package Controller;

import Model.*;
import View.CarView;

import javax.swing.*;
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
    CarView frame;
    CarModel model;

    // A list of cars, modify if needed
    private final static ArrayList<Cars> cars = new ArrayList<>();

    //methods:
    void gas(int amount) {
        model.gas(amount);
    }
    void brake(int amount) {
        model.brake(amount);
    }
    void startEngine(){
        model.startEngine();
    }
    void stopEngine(){
        model.stopEngine();
    }
    void tiltDown(){
        model.tiltDown();
    }
    void tiltUp(){
        model.tiltUp();
    }
    void setTurboOn(){
        model.setTurboOn();
    }
    void setTurboOff(){
        model.setTurboOff();
    }

}
