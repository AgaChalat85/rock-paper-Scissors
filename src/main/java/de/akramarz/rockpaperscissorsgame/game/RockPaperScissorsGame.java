package de.akramarz.rockpaperscissorsgame.game;

import static de.akramarz.rockpaperscissorsgame.enums.MovesEnum.*;
import static de.akramarz.rockpaperscissorsgame.enums.ConfirmationEnum.*;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import de.akramarz.rockpaperscissorsgame.enums.ResultsEnum;
import de.akramarz.rockpaperscissorsgame.gui.GUICreator;
import de.akramarz.rockpaperscissorsgame.moves.MovesEvaluator;
import de.akramarz.rockpaperscissorsgame.player.Computer;
import de.akramarz.rockpaperscissorsgame.player.Human;
import de.akramarz.rockpaperscissorsgame.player.Player;
import de.akramarz.rockpaperscissorsgame.round.Round;
import de.akramarz.rockpaperscissorsgame.score.Score;
import de.akramarz.rockpaperscissorsgame.validation.InputValidation;
import de.akramarz.rockpaperscissorsgame.validation.ValidationResponse;

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
        MovesEnum playerMove = this.human.makeMove();

        if (!playerMove.isEvaluatable()) {
            return new Round(playerMove, null, null);
        }

        MovesEnum computerMove = this.computer.makeMove();
        ResultsEnum result = new MovesEvaluator().evaulate(playerMove, computerMove).get();

        return new Round(playerMove, computerMove, result);
    }

    private boolean checkIfRestart(MovesEnum playerMove) {
        return playerMove.equals(RESTART);
    }

    private boolean checkIfQuit(MovesEnum playerMove) {
        return playerMove.equals(QUIT);
    }
    
    private boolean checkIfRestartConfirmed() {
        while(true) {
            String confirmation = GUICreator.getRestartConfirmation();
            ValidationResponse validationResponse = InputValidation.validateConfirmationValue(confirmation);
            
            if(validationResponse.isValid()) {
                return confirmation.equals(YES.getValue());
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
                return confirmation.equals(YES.getValue());
            } else {
                System.out.println(validationResponse.getWarning());
            }
        }
    }

    private boolean checkIfRestartOrQuit(MovesEnum playerMove) {
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
