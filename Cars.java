import java.awt.*;
import java.security.InvalidParameterException;

/**
 * An abstract superclass for all different kinds of cars.
 * Shared methods and functions for all cars are included.
 * Implements the interface Movable and imports java.awt and java.lang.Math.
 */
public abstract class Cars implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    //private Direction direction = Direction.NORTH;
    private int deg = 0;
    private double posX = 0;
    private double posY = 0;

    /**
     * Constructor for a car.
     *
     * @param nrDoors     Indicates the number of doors on the car.
     * @param enginePower Indicates the power of the engine of the car.
     * @param color       Indicates the color of the car.
     * @param modelName   Indicates the name of a certain car model.
     */
    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }


    /**
     * Starts the engine of the car. Effectively sets currentSpeed to 0.1
     */
    void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine of the car. Effectively sets currentSpeed to 0.
     */
    void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Abstract method for the speedFactor element. This has certain properties depending on car model.
     *
     * @return Null.
     */
    public abstract double speedFactor();


    /**
     * A method that increments the speed of our Cars by the following formula.
     * currentSpeed = getCurrentSpeed() + speedFactor * amount
     *
     * @param amount This value is determined by the gas() method. Valid range [0,1]
     */

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        } else if (currentSpeed < 0) { currentSpeed = 0;
        }
    }

    /**
     * A method that decrements the speed of our Cars by the following formula.
     * currentSpeed = getCurrentSpeed() - speedFactor * amount
     *
     * @param amount This value is determined by the break() method. Valid range [0,1]
     */
    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed > enginePower) { currentSpeed = enginePower;
        } else if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    /**
     * A method that makes our cars able to move. Functions on a degree basis.
     * The method calculates the horizontal and vertical velocities of the car.
     * Horizontal velocity is calculated by taking the cos(angle) * currentSpeed of the car.
     * Vertical velocity is calculated by taking the sin(angle) * currentSpeed of the car.
     * Position is thereafter updated.
     */
    @Override
    public void move() {
        double horizontalSpeed = currentSpeed * Math.cos(Math.toRadians(getDeg()));
        setPosX(getPosX() + horizontalSpeed);
        double verticalSpeed = currentSpeed * Math.sin(Math.toRadians(getDeg()));
        setPosY(getPosY() + verticalSpeed);
    }


    /**
     * A method that turns our car to the left by the value of one degree per instance.
     */
    @Override
    public void turnLeft() {
        deg = deg + 1;
    }

    /**
     * A method that turns our car to the right by the value of one degree per instance.
     */
    @Override
    public void turnRight() {
        deg = deg - 1;
    }

    /**
     * A method that calls the incrementSpeed method if the amount is between 0 and 1.
     *
     * @param amount Indicates how much the car gases from a scale from 0 to 1.
     * @throws InvalidParameterException if amount is not between 0 and 1.
     */
    void gas(double amount) throws InvalidParameterException {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * A method that calls the decrementSpeed method if the amount is between 0 and 1.
     *
     * @param amount Indicates how hard the car breaks from a scale from 0 to 1.
     * @throws InvalidParameterException if amount is not between 0 and 1.
     */
    void brake(double amount) throws InvalidParameterException {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * @return Engine power of the car
     */
    double getEnginePower() {
        return enginePower;
    }

    /**
     * @return Current speed of the car
     */
    double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets current speed of the car.
     *
     * @param currentSpeed New current speed
     */
    void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

    /**
     * @return posX
     */
    double getPosX() {
        return posX;
    }

    /**
     * Sets position on the X-axis.
     *
     * @param posX = new value for posX
     */
    private void setPosX(double posX) {
        this.posX = posX;
    }

    /**
     * @return posY
     */
    double getPosY() {
        return posY;
    }

    /**
     * Sets position on the Y-axis.
     *
     * @param posY = new value for posY
     */
    private void setPosY(double posY) {
        this.posY = posY;
    }

    /**
     * @return int deg
     */
    int getDeg() {
        return deg;
    }

    /**
     * Sets the angle/direction for the car.
     *
     * @param deg = new value for the angle
     */
    void setDeg(int deg) {
        this.deg = deg;
    }
}
