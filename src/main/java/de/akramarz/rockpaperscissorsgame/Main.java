package de.akramarz.rockpaperscissorsgame;

import de.akramarz.rockpaperscissorsgame.game.Game;
import de.akramarz.rockpaperscissorsgame.game.RockPaperScissorsGame;

public class Main {
    
    public static void main(String[] args) {
        
        Game rockPaperScissorsGame = new RockPaperScissorsGame();
        rockPaperScissorsGame.play();
    }
}
