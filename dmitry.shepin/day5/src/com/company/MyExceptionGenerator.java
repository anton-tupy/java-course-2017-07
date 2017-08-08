package com.company;

public class MyExceptionGenerator implements ExceptionGenerator {
    @Override
    public void generateNullPointerException() {
        Object o = null;
        o.toString();
    }

    @Override
    public void generateClassCastException() {
        Object o = (String) (Object) 5;
    }


    @Override
    public void generateNumberFormatException() {
        String line = "example";
        double number = Double.parseDouble(line);
    }

    @Override
    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError() {
        Integer[] buffer = new Integer[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
