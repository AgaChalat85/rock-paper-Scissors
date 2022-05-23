package de.akramarz.rockpaperscissorsgame.player;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import java.util.Random;

public class Computer extends Player {

    @Override
    public MovesEnum makeMove() {
        String moveButton = String.valueOf(new Random().nextInt(MovesEnum.getAllEvaluatable().size()) + 1);       
        return MovesEnum.findByMoveButton(moveButton);
    }
    
}
