package com.company.guessFromMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class GuessMyVersion {

        /** ЗАДАЧА. Реализовать игру “угадай число”. Программа загадывает случайное число в пределах от 1 до 100.
        Задача игрока - отгадать это число не более чем за восемь попыток. После каждой попытки программа
        подсказывает больше загаданное число или меньше предполагаемого. При проигрыше
        программа показывает загаданное число. Разделите реализацию пользовательского интерфейса и
        логику игры с помощью классов.
         */


    public static void main(String[] args) throws IOException {
        System.out.println("ИГРА УГАДАЙ ЧИСЛО!");
        System.out.println("Чтобы сдаться введите 0...");
        // Создаём буферизацию ввода
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(reader);

        // Создаём рандом число
        Random r = new Random();

        // Генерируем число от 1 до 100
        int randomNumber = r.nextInt(100) + 1;

        // Вводимое число
        int inputNumber;

        // Число попыток
        int j;
        int maxNumberOfAttempts = 8;
        for (j = 0; j < maxNumberOfAttempts; j++) {

            System.out.println("Введите число:");
            inputNumber = Integer.parseInt(rd.readLine());
            if (inputNumber == 0) {
                break;
            }
            if (inputNumber > randomNumber) {
                System.out.println("Много :)");
            }

            if (inputNumber < randomNumber) {
                System.out.println("Мало :)");
            }


            if (inputNumber == randomNumber) {
                break;
            }

        }

        if (j == maxNumberOfAttempts) {
            System.out.println("Вы проиграли!");
            System.out.println("Число попыток: " + j);
            System.out.println("Загаданное число " + randomNumber);
        } else {
            System.out.println("Вы выиграли!!!");
            System.out.println("Число попыток: " + j);
        }
    }
}

