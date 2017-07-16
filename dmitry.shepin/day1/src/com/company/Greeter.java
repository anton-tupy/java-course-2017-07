package com.company;

/**
 * Created by IT-Academy on 13.07.2017.
 */
public class Greeter {

    private String greet;

    public Greeter() {
        this("Hello");
    }

    public Greeter(String greet) {
        this.greet = greet;
    }

    public void greet() {
        greet("World");
    }

    public void greet(String name) {
        System.out.println(greet + ", " + name);
    }
}
