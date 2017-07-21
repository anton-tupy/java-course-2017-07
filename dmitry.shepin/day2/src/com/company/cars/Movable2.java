package com.company.cars;

/**
 * Created by IT-Academy on 15.07.2017.
 */
public interface Movable2 {
    void move();

    default void moveTwice() {
        move();
        move();
    }
}
