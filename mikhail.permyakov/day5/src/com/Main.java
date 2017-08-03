package com;

/**
 * Created by lab on 03.08.2017.
 */
public class Main {
    public static void main(String[] args) {

        MyExceptionGenerator myExceptionGenerator = new MyExceptionGenerator();

        try {
            myExceptionGenerator.generateNullPointerException();

        } catch (Throwable e) {
            e.printStackTrace();
        }


        try {
            myExceptionGenerator.generateClassCastException();
        } catch (Throwable e){
            e.printStackTrace();
        }

        try {
            myExceptionGenerator.generateNumberFormatException();
        } catch (Throwable e){
            e.printStackTrace();
        }

        try {
            myExceptionGenerator.generateStackOverflowError();
        } catch (Throwable e){
            e.printStackTrace();
        }

        try {
            myExceptionGenerator.generateOutOfMemoryError();
        } catch (Throwable e){
            e.printStackTrace();
        }

        try {
            myExceptionGenerator.generateMyException("||||||||||||||||||||||||||");
        } catch (Throwable e){
            e.printStackTrace();
        }




    }
}
