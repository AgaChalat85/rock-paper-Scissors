package de.akramarz.rockpaperscissorsgame.player;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import de.akramarz.rockpaperscissorsgame.gui.GUICreator;
import de.akramarz.rockpaperscissorsgame.validation.InputValidation;
import de.akramarz.rockpaperscissorsgame.validation.ValidationResponse;

public class Human extends Player {
    
    public Human(String name) {
        super(name);
    }
    
    @Override
    public MovesEnum makeMove() {
        while(true) {
            String playerMove = GUICreator.makePlayerMove();
            ValidationResponse validationRespone = InputValidation.validatePlayerMove(playerMove);
            
            if(validationRespone.isValid()) {
                return MovesEnum.findByMoveButton(playerMove);
            } else {
                System.out.println(validationRespone.getWarning());
            }
        }
    }  
}
