import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Freightliner extends Cars implements Loadable {
    private int tiltDeg;
    private final int maxCars;
    private final Deque<Cars> loaded = new ArrayDeque<>();

    public Freightliner() {
        super(2, 60, Color.blue, "Freightliner");
        this.maxCars = 3;
        this.tiltDeg = 0;
    }

    @Override
    public void tiltUp() {
        this.tiltDeg = 0;
    }

    @Override
    public void tiltDown() {
        this.tiltDeg = 70;
    }

    public void loadCar(Cars c){
        if (loaded.size() < maxCars && this.tiltDeg == 70 && c != this && !loaded.contains(c)){ //add distance between car and carrier
            loaded.push(c);
        }
    }
    public void unloadCar(){
        if (loaded.size() > 0 && this.tiltDeg == 70){ //set coordinates to carriers coordinates, private setters obstructing
            loaded.pop();
        }
    }

    public double getTiltDeg() {
        return tiltDeg;
    }

    public int getAmountLoaded() {
        return loaded.size();
    }

    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    @Override
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    public double speedFactor(){
        return getEnginePower();
    }
}
