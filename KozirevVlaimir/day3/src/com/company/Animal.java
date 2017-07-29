package com.company;


public class Animal implements Runner {

    private int  speed = 10;

    public void run() {
        System.out.println("I'm run! " + " speed= " + speed);
    }
}
