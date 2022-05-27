package com.kodilla.rockpaperscissorsgame.round;

import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;
import com.kodilla.rockpaperscissorsgame.enums.ResultsEnum;

public class Round {
    
    private final CommandEnum playerMove;
    private final CommandEnum computerMove;
    private final ResultsEnum result;

    public Round(CommandEnum playerMove, CommandEnum computerMove, ResultsEnum result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public CommandEnum getPlayerMove() {
        return playerMove;
    }

    public CommandEnum getComputerMove() {
        return computerMove;
    }

    public ResultsEnum getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Round{" + "playerMove=" + playerMove + ", computerMove=" + computerMove + ", result=" + result + '}';
    }
}
