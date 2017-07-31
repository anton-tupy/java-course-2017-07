package com.company;

public class Main {
//    static{
//        try{
//            InputStream in = Calculator.class.getResourceAsStream("File1");
//            p.load(in);//load(Reader), loadFromXML(InputStream)
//            in.close();
//        }catch(IOException e){}
//    }

    public static void main(String[] args) throws ClassNotFoundException {
        Calculator calculator = new Calculator();
        calculator.run(args.length > 0 ? args[0] : null);
    }
}
