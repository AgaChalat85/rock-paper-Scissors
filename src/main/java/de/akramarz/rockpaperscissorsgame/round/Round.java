package de.akramarz.rockpaperscissorsgame.round;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import de.akramarz.rockpaperscissorsgame.enums.ResultsEnum;

public class Round {
    
    private final MovesEnum playerMove;
    private final MovesEnum computerMove;
    private final ResultsEnum result;

    public Round(MovesEnum playerMove, MovesEnum computerMove, ResultsEnum result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public MovesEnum getPlayerMove() {
        return playerMove;
    }

    public MovesEnum getComputerMove() {
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
