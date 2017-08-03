package com;

import java.util.ArrayList;

/**
 * Created by lab on 03.08.2017.
 */
public class MyExceptionGenerator implements ExceptionGenerator {

    @Override
    public void generateNullPointerException() {
        Object o = null;
        o.toString();
    }

    @Override
    public void generateClassCastException() {

        Object o;
        o = (int)5;

        String str = (String)o;

    }

    @Override
    public void generateNumberFormatException() {
        String str = "NaN";

        int i = Integer.parseInt(str);

    }

    @Override
    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError() {
       /* ArrayList<Object> list = new ArrayList<>();
        while (true){
            list.add(new Object());
        }*/
       Integer[] buffer = new Integer[Integer.MAX_VALUE];

    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
