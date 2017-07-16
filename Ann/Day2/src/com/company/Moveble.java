package com.company;

/**
 * Created by It-Academy-5 on 15.07.2017.
 */
public interface Moveble {
    void move();

    default void moveTwice() {
        move();
        move();
    }
}
