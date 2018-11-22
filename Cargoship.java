import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Cargoship implements Loadable,Movable { //not working right now
    Freightliner loader = new Freightliner();
    private final int maxCars;
    private final int enginePower;
    private final Deque<Cars> tmp = new ArrayDeque<>(); //Solve issue with loading of in the other order from this class

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
    private int getEnginePower() {
        return enginePower;
    }

    public double getTiltDeg() {
        return loader.getTiltDeg();
    }

}
