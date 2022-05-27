package com.kodilla.rockpaperscissorsgame.score;

import com.kodilla.rockpaperscissorsgame.enums.ResultsEnum;
import com.kodilla.rockpaperscissorsgame.player.Player;

public class Score {
    
    private final Player human;
    private final Player computer;
    private int draws;
    private int wonRoundsNumber;
    
    public Score(Player human, Player computer, int wonRoundsNumber) {
        this.human = human;
        this.computer = computer;
        this.wonRoundsNumber = wonRoundsNumber;
    }

    public int getHumanScore() {
        return this.human.getScore();
    }
    
    public int getComputerScore() {
        return this.computer.getScore();
    }
    
    public int getDraws() {
        return this.draws;
    }
    
    public void reset() {
        this.human.resetScore();
        this.computer.resetScore();
        this.draws = 0;
    }
    
    public void actualise(ResultsEnum result) {
        switch(result) {
            case PLAYER_WINS:
                human.incrementScore();
                break;
            case COMPUTER_WINS:
                computer.incrementScore();
                break;
            case DRAW:
                draws++;
                break;
            default:
                throw new IllegalArgumentException("The following result " + result.name() + " is not supported!");
        }
    }
    
    public boolean checkIfThereAWinner() {
        if(human.getScore() == wonRoundsNumber) {
            System.out.println("Gracz wygrywa!");
            return true;
        } else if(computer.getScore() == wonRoundsNumber) {
            System.out.println("Komputer wygrywa!");
            return true;
        }
        return false;
    }
}
