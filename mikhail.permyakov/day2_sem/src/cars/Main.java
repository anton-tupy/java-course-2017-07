package cars;

/**
 * Created by lab on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.move();

        Vehicle vehicle = new Car();

        vehicle.move();

        Ship ship = new Ship();
        vehicle = new Ship();
        vehicle.move();

        Movable movable = new Ship();
        movable.move();

        car.moveTwice();
    }
}
