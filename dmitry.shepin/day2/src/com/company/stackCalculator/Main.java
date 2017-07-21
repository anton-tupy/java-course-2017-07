package com.company.stackCalculator;


import java.io.*;
import java.util.Scanner;

/**
 * Created by Dmitry on 17.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(20);
        stack.push(5);

       /* double a = stack.define();
        stack.push(a);
        stack.doOperation("sqrt");
        stack.printTopItem();*/


        try (Scanner scanner = new Scanner(new FileReader("OperationForCalculator"))) {
            while (scanner.hasNext()) {
                if (stack.size() == 0) {
                    System.out.println("Невозможно выполнить операция т.е стек пустой");
                    double a = stack.define();
                    stack.push(a);
                }

                String operation = scanner.nextLine();
                Stack.Operation kindOfOperation = stack.findOperation(operation);

                stack.doOperation(kindOfOperation);

                System.out.printf("Операция:(%s);%n", operation);
                stack.printTopItem();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Нет файла");
        }



        System.out.println("Наберите операцию: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String operation1 = reader.readLine();
        Stack.Operation kindOfOperation = stack.findOperation(operation1);

        stack.doOperation(kindOfOperation);

        System.out.printf("Операция:(%s);%n", operation1);
        stack.printTopItem();
        System.out.println();

    }

}

