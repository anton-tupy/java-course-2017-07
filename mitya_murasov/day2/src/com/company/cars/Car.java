package com.company.cars;

/**
 * Created by mitya murasov on 15.07.2017.
 */
public class Car extends Vehicle
{
    @Override
    public void move()
    {
        System.out.println("Car drive");
    }

    public void moveTriple()
    {
        move();
        move();
        move();
    }
}
