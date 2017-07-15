package com.company;


public interface Movable {
    void move();

    default void moveTwice(){
        move();
        move();
    }
}
