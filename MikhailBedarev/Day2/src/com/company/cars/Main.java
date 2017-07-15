package com.company.cars;

/**
 * Created by WizZo on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        Vehicle vehicle = new Car();
        vehicle.move();
        vehicle = new Ship();
        vehicle.move();
        car.moveTwice();

        Movable mvb = new Ship();
        mvb.move();
    }
}
