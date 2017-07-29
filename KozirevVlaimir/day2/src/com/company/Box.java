package com.company;


public class Box {
    double width;
    double height;
    double depth;

    Box(double w,double h,double d){
        width = w;
        height = h;
        depth = d;
    }
    Box(){
        width =-1;
        height =-1;
        depth =-1;
    }
    Box(double len){
        width = height = depth = len;
    }
    double volume(){
        return width * height * depth;
    }
}

class BoxWeigth extends Box{
    double weigth;

    BoxWeigth (double w, double h, double d,double m){
        width = w;
        height = h;
        depth = d;
        weigth = m;
    }
}

class DemoBoxWeigth{
    public static void main(String[] args) {
        BoxWeigth mybox1 = new BoxWeigth(10,20,15,34.3);
        BoxWeigth mybox2 = new BoxWeigth(2,3,4,0.076);
        double vol;

        vol = mybox1.volume();
        System.out.println("Объем первого равен: " + vol);
        System.out.println("Вес первого равен: " + mybox1.weigth);
        System.out.println();

        vol = mybox2.volume();
        System.out.println("Объем второго равен: " + vol);
        System.out.println("Вес второго равен: " + mybox2.weigth);
    }
}
