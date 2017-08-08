package com.company;

public class Main {

    public static void main(String[] args) {

        Husband husband = new Husband("Vova", 29);
        husband.person();

        Wife wife = new Wife("Lora",31);
        wife.person();

        Son son = new Son("Leva",6);
        son.person();


    }
}
