package com.kodilla.rockpaperscissorsgame.player;

import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;

import java.util.Random;

public class Computer extends Player {

    @Override
    public CommandEnum makeMove() {
        String moveButton = String.valueOf(new Random().nextInt(CommandEnum.getAllMovable().size()) + 1);
        return CommandEnum.findByMoveButton(moveButton);
    }
    
}
