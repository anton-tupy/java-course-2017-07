package com.company;

import java.util.Random;

/**
 * Created by Лидия on 14.07.2017.
 */
public class Calcs {
    static int getNum(int max_num) {
        Random random = new Random();
        return random.nextInt(max_num);
    }

    static String getAnswer( int number_to_find , int number_find, int number_chance_cnt,  int number_chance) {
        boolean find_num = false;
        String str_ans = "";
        if (number_chance_cnt <= number_chance) {
            if (number_find < number_to_find) {
                str_ans = "Загаданное число больше";
            } else if (number_find > number_to_find) {
                str_ans = "Загаданное число меньше";
            } else if (number_find == number_to_find) {
                find_num = true;
                str_ans = "Бинго!";
            }
            ;
        }

        if (number_chance_cnt == number_chance & find_num == false ) {
            str_ans = "Не угадали. Число было: " + number_to_find;
        }

        return str_ans;
    }
}
