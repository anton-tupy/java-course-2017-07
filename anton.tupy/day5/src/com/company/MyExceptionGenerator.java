package com.company;

/**
 * Created by IT-Academy on 03.08.2017.
 */
public class MyExceptionGenerator implements ExceptionGenerator {
    @Override
    public void generateNullPointerException() {
        Object o = null;
        o.toString();
    }

    @Override
    public void generateClassCastException() {
        Object o = (String)(Object)5;
    }

    @Override
    public void generateNumberFormatException() {
        Integer.valueOf("qwe123");
    }

    @Override
    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError() {
        Integer[] buffer = new Integer[Integer.MAX_VALUE / 32];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
