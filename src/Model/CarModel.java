package Model;

import Observer.ModelObserver;

import java.util.ArrayList;
import java.util.List;


public class CarModel{

    private final static ArrayList<Cars> cars = new ArrayList<>();
    List<ModelObserver> modelObservers = new ArrayList<ModelObserver>();

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars) {
            car.gas(gas);
        }

    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Cars car : cars
        ) {
            car.brake(brake);
        }
    }
    public void startEngine(){
        for (Cars car : cars){
            car.startEngine();
        }
    }
    public void stopEngine(){
        for (Cars car : cars){
            car.stopEngine();
        }
    }
    public void tiltDown(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void tiltUp(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void setTurboOn(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void setTurboOff(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public static ArrayList<Cars> getCars() {
        return cars;
    }

}
