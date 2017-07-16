package com.company.cars;

/**
 * Created by IT-Academy on 15.07.2017.
 */
public abstract class Vehicle implements Movable, Movable2 {

    public abstract void move();

    @Override
    public void moveTwice() {
        move();
        move();
    }
}
