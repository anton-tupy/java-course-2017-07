package com.company.cars;

/**
 * Created by WizZo on 15.07.2017.
 */
public interface Movable {
    void move();

    default void moveTwice(){
        move();
        move();
    }
}
