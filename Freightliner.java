import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Freightliner extends Cars implements Loadable {
    private double tiltDeg;
    private final int maxCars;
    private final List<Cars> loaded = new ArrayList<>();

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
        if (loaded.size() < maxCars && this.tiltDeg == 70 && c != this && !loaded.contains(c)){//add distance between car and carrier
            loaded.add(c);
            c.setSamePos(this);
        }
    }
    public void unloadCar(){
        if (loaded.size() > 0 && this.tiltDeg == 70){ //set coordinates to carriers coordinates, private setters obstructing
            loaded.remove(loaded.size() - 1);
        }
    }

    public double getTiltDeg() {
        return tiltDeg;
    }

    public int getAmountLoaded() {
        return loaded.size();
    }

    public List<Cars> getLoaded() {
        return loaded;
    }

    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    @Override //Get these ones better some way code reuse
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    @Override
    public void move() {
        super.move();
        for (Cars c : loaded){
            c.setSamePos(this);
        }
    }

    public double speedFactor(){
        return getEnginePower();
    }
}
