package com.jcourse.permyakov.guess;

import java.util.Random;

public class GuessLogic {

    final static int COMPUTER = 0;
    final static int HUMAN = 1;

    private int winner;
    private int attempts;
    private int userGuess;
    private int secretNumber;

    public GuessLogic(){
        this.attempts = 8;
        Random random = new Random();
        this.secretNumber = random.nextInt(100);
    }

    public boolean isHumanWon(int userGuess){
        if (userGuess == secretNumber){
            setWinner(HUMAN);
            return true;
        }
        return false;
    }

    public String getCongratsMessage(int winner) {
         if (winner == HUMAN) {
             return ("Congrats! You win!");
         } else if (winner == COMPUTER){
             return ("Computer wins!");
        } else return "";
    }

    public void printFeedBack(int userGuess){
        if (userGuess > secretNumber){
            System.out.println("Try smaller");
        }else{
            System.out.println("Try larger");
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
