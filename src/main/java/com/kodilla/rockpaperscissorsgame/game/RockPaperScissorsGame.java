package com.kodilla.rockpaperscissorsgame.game;

import com.kodilla.rockpaperscissorsgame.enums.ConfirmationEnum;
import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;
import com.kodilla.rockpaperscissorsgame.enums.ResultsEnum;
import com.kodilla.rockpaperscissorsgame.moves.MovesEvaluator;
import com.kodilla.rockpaperscissorsgame.player.Computer;
import com.kodilla.rockpaperscissorsgame.player.Human;
import com.kodilla.rockpaperscissorsgame.player.Player;
import com.kodilla.rockpaperscissorsgame.round.Round;
import com.kodilla.rockpaperscissorsgame.score.Score;
import com.kodilla.rockpaperscissorsgame.validation.InputValidation;
import com.kodilla.rockpaperscissorsgame.validation.ValidationResponse;
import com.kodilla.rockpaperscissorsgame.gui.GUICreator;

public class RockPaperScissorsGame implements Game {

    private final Score score;
    private Player human;
    private final Player computer;
    private boolean play;
    private int wonRoundsNumber;

    public RockPaperScissorsGame() {
        createHumanPlayer();
        readRoundsNumber();
        computer = new Computer();
        score = new Score(human, computer, wonRoundsNumber);
    }

    @Override
    public void play() {
        this.play = true;

        while (play) {
            GUICreator.showUserManuals();
            Round round = executeRound();

            if(checkIfRestartOrQuit(round.getPlayerMove())) continue;
            
            GUICreator.showRoundSummary(round);
            score.actualise(round.getResult());
            GUICreator.showScore(score);

            if (score.checkIfThereAWinner()) {
                this.play = false;
            }
        }
    }

    @Override
    public void reset() {
        this.score.reset();
        System.out.println("Gra zostala zresetowana.");
    }

    @Override
    public void end() {
        System.out.printf("Koniec gry!");
        this.play = false;
    }

    private void createHumanPlayer() {
        while (true) {
            String humanPlayerName = GUICreator.getHumanPlayerName();
            ValidationResponse validationResponse = InputValidation.validateHumanPlayerName(humanPlayerName);

            if (validationResponse.isValid()) {
                this.human = new Human(humanPlayerName);
                break;
            } else {
                System.out.println(validationResponse.getWarning());
            }
        }
    }

    private void readRoundsNumber() {
        while (true) {
            String wonRoundsNumberString = GUICreator.getRoundsNumber();
            ValidationResponse validationResponse = InputValidation.validateWonRoundsNumber(wonRoundsNumberString);

            if (validationResponse.isValid()) {
                this.wonRoundsNumber = Integer.parseInt(wonRoundsNumberString);
                break;
            } else {
                System.out.println(validationResponse.getWarning());
            }
        }
    }

    private Round executeRound() {
        CommandEnum playerMove = this.human.makeMove();

        if (!playerMove.isMovable()) {
            return new Round(playerMove, null, null);
        }

        CommandEnum computerMove = this.computer.makeMove();
        ResultsEnum result = new MovesEvaluator().getResult(playerMove, computerMove).get();

        return new Round(playerMove, computerMove, result);
    }

    private boolean checkIfRestart(CommandEnum playerMove) {
        return playerMove.equals(CommandEnum.RESTART);
    }

    private boolean checkIfQuit(CommandEnum playerMove) {
        return playerMove.equals(CommandEnum.QUIT);
    }
    
    private boolean checkIfRestartConfirmed() {
        while(true) {
            String confirmation = GUICreator.getRestartConfirmation();
            ValidationResponse validationResponse = InputValidation.validateConfirmationValue(confirmation);
            
            if(validationResponse.isValid()) {
                return confirmation.equals(ConfirmationEnum.YES.getValue());
            } else {
                System.out.println(validationResponse.getWarning());
            }
        }
    }
    
    private boolean checkIfQuitConfirmed() {
        while(true) {
            String confirmation = GUICreator.getQuitConfirmation();
            ValidationResponse validationResponse = InputValidation.validateConfirmationValue(confirmation);
            
            if(validationResponse.isValid()) {
                return confirmation.equals(ConfirmationEnum.YES.getValue());
            } else {
                System.out.println(validationResponse.getWarning());
            }
        }
    }

    private boolean checkIfRestartOrQuit(CommandEnum playerMove) {
        if (checkIfRestart(playerMove)) {
            if(checkIfRestartConfirmed()) this.reset();
            return true;
        } else if (checkIfQuit(playerMove)) {
            if(checkIfQuitConfirmed())this.end();
            return true;
        } 
        return false;
    }
}
