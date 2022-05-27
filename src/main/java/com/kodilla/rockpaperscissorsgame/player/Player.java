package com.kodilla.rockpaperscissorsgame.player;

import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;

public abstract class Player {
    
    private final String name;
    private int score;
    
    public Player() {
        this.name = "Komputer";
    }
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    public void incrementScore() {
        this.score++;
    }
    
    public void resetScore() {
        this.score = 0;
    }
    
    public abstract CommandEnum makeMove();

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", score=" + score + '}';
    }
}
