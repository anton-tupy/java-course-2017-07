package com.company;


public class Animal {
    private final String name;

    public Animal(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Animal with name" + name;
    }
}
