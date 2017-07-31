package com.company.stackCalculator;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Dmitry on 17.07.2017.
 */
public class Stack {
    private double[] stack = new double[10];
    private int indexOfTop;
    private int size;

    //Инициализация верхушки стэка
    public Stack() {
        indexOfTop = -1;
    }

    //Заталкивание элемента в стэк:
    public void push(double item) {
        if (9 == indexOfTop) {
            System.out.println("Стек полон");
        } else {
            stack[++indexOfTop] = item;
            size++;
        }
    }

    //Выталкивание элемента из стэка:
    public double pop() {
        if (indexOfTop < 0) {
            System.out.println("Стек не загружен");
            return 0;
        } else {
            size--;
            return stack[indexOfTop--];

        }
    }

    public void printTopItem() {
        System.out.println("Верхний элемент = " + stack[indexOfTop]);
    }

    public int size() {
        return size;
    }

    public double define() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число: ");
        return s.nextDouble();
    }

    public void addition() {
        this.push(this.pop() + this.pop());
    }

    private void subtraction() {
        this.push(this.pop() - this.pop());
    }

    private void division() {
        this.push(this.pop() / this.pop());
    }

    private void root() {
        this.push(Math.sqrt(this.pop()));
    }

    private void multiplication() {
        this.push(this.pop() * this.pop());
    }

    public void doOperation(Operation doOperation) {
        switch (doOperation) {
            case ADDITION:
                this.addition();
                break;
            case MULTIPLICATION:
                this.multiplication();
                break;
            case SUBTRACTION:
                this.subtraction();
                break;
            case DIVISION:
                this.division();
                break;
            case ROOT:
                this.root();
                break;

        }
    }


    public enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        ROOT
    }

    public Operation findOperation(String Operation) {
        if (Objects.equals(Operation, "+")) {
            return Stack.Operation.ADDITION;
        }

        if (Objects.equals(Operation, "-")) {
            return Stack.Operation.SUBTRACTION;
        }

        if (Objects.equals(Operation, "*")) {
            return Stack.Operation.MULTIPLICATION;
        }

        if (Objects.equals(Operation, "/")) {
            return Stack.Operation.DIVISION;
        }

        return Stack.Operation.ROOT;
    }


}
