package com.company.cars;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        Vehicle vehicle = new Car();
        vehicle.move();

        vehicle = new Ship();
        vehicle.move();

        Movable movable = new Ship();
        movable.move();

        car.moveTwice();

        car.moveTriple();

    }
}
