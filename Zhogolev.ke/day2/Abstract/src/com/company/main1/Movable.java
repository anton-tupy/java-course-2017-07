package com.company.main1;

/**
 * Created by konsz on 15.07.2017.
 */
public interface Movable {
    void  move();
    default void moveTwice(){
        move();
        move();
    }


}
