package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        Vehicle vehicle = new Car();
        vehicle.move();

        vehicle = new Ship();
        vehicle.move();

        Moveble moveble = new Ship();
        moveble.move();

        car.moveTwice();

        Ship ship = new Ship();

    }
}
