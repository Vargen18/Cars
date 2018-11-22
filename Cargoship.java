
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Cargoship implements Loadable,Movable { //not working right now
    Freightliner loader = new Freightliner();
    private final int maxCars;
    private final int enginePower;
    private final List<Cars> loaded = new ArrayList<>(); //Solve issue with loading of in the other order from this class

    Cargoship(){
        this.maxCars = 10;
        this.enginePower = 30;
    }

    @Override
    public void tiltDown() {
        loader.tiltDown();
    }

    @Override
    public void tiltUp() {
        loader.tiltUp();
    }

    @Override
    public void move() {
        loader.move();
    }

    @Override
    public void turnLeft() {
        loader.turnLeft();
    }

    @Override
    public void turnRight() {
        loader.turnRight();
    }
    void startEngine() {
        loader.startEngine();
    }
    void stopEngine() {
        loader.stopEngine();
    }
    void gas(double amount) throws InvalidParameterException {
        loader.gas(amount*(this.getEnginePower() / loader.getEnginePower()));
    }
    void brake(double amount) throws InvalidParameterException {
        loader.brake(amount*(this.getEnginePower() / loader.getEnginePower()));
    }
    public void loadCar(Cars c) {
        if (loaded.size() < maxCars && loader.getTiltDeg() == 70 && !loaded.contains(c)) {//add distance between car and carrier
            loaded.add(c);
        }
    }
    public void unloadCar(){
        if (loaded.size() > 0 && loader.getTiltDeg() == 70) { //set coordinates to carriers coordinates, private setters obstructing
                loaded.remove(loaded.get(0));
        }
    }
    private int getEnginePower() {
        return enginePower;
    }

    public double getTiltDeg() {
        return loader.getTiltDeg();
    }

    public int getAmountLoaded() {
        return loaded.size();
    }

    public List<Cars> getLoaded() {
        return loaded;
    }
    double getPosY() {
        return loader.getPosY();
    }
    double getPosX() {
        return loader.getPosX();
    }
    double getCurrentSpeed() {
        return loader.getCurrentSpeed();
    }
    int getDeg() {
        return loader.getDeg();
    }
}
