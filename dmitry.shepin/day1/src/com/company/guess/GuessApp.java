package com.company.guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IT-Academy on 15.07.2017.
 */
public class GuessApp {
    public static void main(String[] args) throws IOException {
        GuessGame game = new GuessGame(8, 100);

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        loop:
        while(true) {
            System.out.println("Введите число:");
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            int number;
            try {
                number = Integer.parseInt(line);
            }
            catch (NumberFormatException e) {
                System.out.println("Не число");
                continue;
            }
            GuessGame.TryResult tryResult = game.doTry(number);
            switch (tryResult) {
                case SUCCESS:
                    System.out.println("Вы угадали.");
                    System.out.println("Количество попыток: " + game.getTriesCount());
                    break loop;
                case LESS:
                    System.out.println("Мало");
                    break;
                case MORE:
                    System.out.println("Много");
                    break;
                case FAIL:
                    System.out.println("Вы проиграли.");
                    System.out.println("Загаданное число: " + game.getNumber());
                    break loop;
            }
        }
        bufferedReader.close();
        reader.close();
    }
}
