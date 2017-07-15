package com.company;

/**
 * Created by It-Academy-5 on 13.07.2017.
 */
public class Greeter {
    private String greet;
    public Greeter(){
        this("Hello");
    };

    public Greeter(String greet){
        this.greet = greet;
    };

    public void greet() {
        greet("Ann");
    }

    public void greet(String name) {
        System.out.println(greet + ", " + name);
    }
}
