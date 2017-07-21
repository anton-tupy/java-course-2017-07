package com.company.guessFromMe;

import java.util.Scanner;

/**
 * Created by Dmitry on 16.07.2017.
 */
public class GuessAppShepin {
    public static void main(String[] args) {
        GuessGameShepin game1 = new GuessGameShepin(8, 100);

        Scanner scanner = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("Введите число: ");

            String line = scanner.nextLine();

            if (null == line) {
                break;
            }

            int inputNumber;
            try {
                inputNumber = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Не число :(");
                continue;
            }

            TryResult tryResult = game1.doTry(inputNumber);
            switch (tryResult) {
                case SUCCESS:
                    System.out.println("Вы угадали.");
                    System.out.println("Количество попыток: " + game1.getTriesCount());
                    break loop;
                case LESS:
                    System.out.println("Мало");
                    break;
                case MORE:
                    System.out.println("Много");
                    break;
                case FAIL:
                    System.out.println("Вы проиграли.");
                    System.out.println("Загаданное число: " + game1.getRandomNumber());
                    break loop;
            }

        }
    }
}
