package com.company;

/**
 * Created by Natalya on 15.07.2017.
 */
public class Car extends Vehicle {
    @Override
    public void move() {               //переопределенный метод
        System.out.println("car drive");
    }
}
