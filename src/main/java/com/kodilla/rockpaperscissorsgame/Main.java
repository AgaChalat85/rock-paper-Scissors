package com.kodilla.rockpaperscissorsgame;

import com.kodilla.rockpaperscissorsgame.game.Game;
import com.kodilla.rockpaperscissorsgame.game.RockPaperScissorsGame;

public class Main {
    
    public static void main(String[] args) {
        
        Game rockPaperScissorsGame = new RockPaperScissorsGame();
        rockPaperScissorsGame.play();
    }
}
