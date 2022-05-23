package de.akramarz.rockpaperscissorsgame.validation;

import static de.akramarz.rockpaperscissorsgame.enums.MovesEnum.*;
import static de.akramarz.rockpaperscissorsgame.enums.ConfirmationEnum.*;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import de.akramarz.rockpaperscissorsgame.game.GameWarnings;

public class InputValidation {
    
   private static final int HUMAN_PLAYER_NAME_LENGTH = 3;
    
   public static ValidationResponse validateHumanPlayerName(String humanPlayerName) {
       boolean valid = humanPlayerName.trim().length() >= HUMAN_PLAYER_NAME_LENGTH;
       String warning = null;
       
       if(!valid) {
           warning = String.format(GameWarnings.HUMAN_PLAYER_NAME_LENGTH_WARNING, HUMAN_PLAYER_NAME_LENGTH);
       }
       
       return new ValidationResponse(valid, warning);
   }
   
   public static ValidationResponse validateWonRoundsNumber(String wonRoundsNumber) {
       int wonRoundsNumberDigit;
       boolean valid = true;
       String warning = null;
       
       try {
           wonRoundsNumberDigit = Integer.parseInt(wonRoundsNumber);
       } catch(NumberFormatException ex) {
           valid = false;
           warning = GameWarnings.ROUNDS_NUMBER_NOT_A_DIGIT;
           return new ValidationResponse(valid, warning);
       }
       
       if(wonRoundsNumberDigit < 1) {
           valid = false;
           warning = GameWarnings.ROUNDS_NUMBER_IS_NEGATIVE;
       }
       
       return new ValidationResponse(valid, warning);
   }
   
   public static ValidationResponse validatePlayerMove(String playerMove) {
       MovesEnum move = MovesEnum.findByMoveButton(playerMove.trim());
       boolean valid = true;
       String warning = null;
       
       if(move.equals(NOT_DEFINED)) {
           valid = false;
           warning = String.format(GameWarnings.PLAYER_MOVE_UNDEFINED, playerMove);
       }
       
       return new ValidationResponse(valid, warning);
   }
   
   public static ValidationResponse validateConfirmationValue(String confirmationValue) {
       boolean valid = confirmationValue.equals(YES.getValue()) || confirmationValue.equals(NO.getValue());
       String warning = null;
       
       if(!valid) {
           warning = GameWarnings.CONFIRMATION_VALUE_IS_WRONG;
       }
       
       return new ValidationResponse(valid, warning);
   }
}