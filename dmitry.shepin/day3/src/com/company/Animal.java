package com.company;

public class Animal implements Runner {

    private int speed = 10;
    private int HeightOfJump = 5;


    public void run() {
        System.out.println("I'm running: (speed = " + speed + ")");
    }

    @Override
    public void jump() {
        System.out.println("I'm jumping: (Height of jump = " + HeightOfJump + ")");
    }


}
