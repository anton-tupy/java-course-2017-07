package com.company;

/**
 * Created by Natalya on 15.07.2017.
 */
public interface Movable {       //у интерфейм=са все методы публ и абстрактные
    void move();


    default void moveTwice(){   //defaultный метод  для того чтобы можно было добавлять новые методы не нарушая совместимость
        move();
        move();
    }
}
