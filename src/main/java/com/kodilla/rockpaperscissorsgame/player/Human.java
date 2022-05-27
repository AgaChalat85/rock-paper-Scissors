package com.kodilla.rockpaperscissorsgame.player;

import com.kodilla.rockpaperscissorsgame.validation.InputValidation;
import com.kodilla.rockpaperscissorsgame.validation.ValidationResponse;
import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;
import com.kodilla.rockpaperscissorsgame.gui.GUICreator;

public class Human extends Player {
    
    public Human(String name) {
        super(name);
    }
    
    @Override
    public CommandEnum makeMove() {
        while(true) {
            String playerMove = GUICreator.makePlayerMove();
            ValidationResponse validationRespone = InputValidation.validatePlayerMove(playerMove);
            
            if(validationRespone.isValid()) {
                return CommandEnum.findByMoveButton(playerMove);
            } else {
                System.out.println(validationRespone.getWarning());
            }
        }
    }  
}
