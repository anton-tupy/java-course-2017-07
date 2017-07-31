package com.company;

/**
 * Created by WizZo on 22.07.2017.
 */
public class Animal implements Runner {
    private int speed = 10;

    public void run() {
        System.out.println("I'm Run! (speed = " + speed + ")");

    }
}
