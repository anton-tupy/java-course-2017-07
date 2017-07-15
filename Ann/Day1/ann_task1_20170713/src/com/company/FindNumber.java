package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by It-Academy-5 on 13.07.2017.
 */
public class FindNumber {
    public static void main(String[] args) throws IOException {
        InputStreamReader reeder = new InputStreamReader(System.in);
        BufferedReader bufferReader = new BufferedReader(reeder);

        Random random = new Random();
        int number_to_find = random.nextInt(100);;
        int number_chance = 8;
        int number_chance_cnt = 1;
        int number_find;
        boolean find_num = false;

        while(number_chance_cnt <= number_chance) {
            if (number_chance_cnt == number_chance){
                System.out.println("У вас остался последний шанс");
            }

            String line = bufferReader.readLine();
            if (line == null){
                break;
            }
            number_find = Integer.valueOf(line);
            if (number_find < number_to_find) {
                System.out.println("Загаданное число больше");

            }
            else if (number_find > number_to_find){
                System.out.println("Загаданное число меньше");
            }
            else if (number_find == number_to_find){
                System.out.println("Бинго!");
                find_num = true;
                break;
            }

            number_chance_cnt = number_chance_cnt++;
        }

        if (find_num == false){
            System.out.println("Не угадали. Число =" + number_to_find);
        }
    };

}
