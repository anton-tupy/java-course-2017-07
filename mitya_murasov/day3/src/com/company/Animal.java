package com.company;


/**
 * Created by mitro on 22.07.17.
 */
public class Animal implements Runner
{
    private final int speed = 10;
    public void run()
    {
        System.out.println("I`m running! Speed: " + speed);
    }
}