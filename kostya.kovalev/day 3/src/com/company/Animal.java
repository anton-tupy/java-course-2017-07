package com.company;

/**
 * Created by Natalya on 22.07.2017.
 */
public class Animal implements Runner {
    private int speed=120;


    public void run(){
        System.out.println("I'm run (speed = "+ speed +"km/h)");

    }
}
