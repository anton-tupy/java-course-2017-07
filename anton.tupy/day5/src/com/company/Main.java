package com.company;

public class Main {

    public static void main(String[] args) {
        MyExceptionGenerator exceptionGenerator = new MyExceptionGenerator();
        try {
            exceptionGenerator.generateNullPointerException();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            exceptionGenerator.generateClassCastException();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            exceptionGenerator.generateNumberFormatException();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            exceptionGenerator.generateStackOverflowError();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            exceptionGenerator.generateOutOfMemoryError();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            exceptionGenerator.generateMyException("Error");
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
