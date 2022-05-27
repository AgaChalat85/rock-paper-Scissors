package com.kodilla.rockpaperscissorsgame.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandEnum {
    ROCK("1", "Kamien", true),
    PAPER("2", "Papier", true),
    SCISSORS("3", "Nozyce", true),
    LIZARD("4", "Jaszczurka", true),
    SPOCK("5", "Spock", true),
    RESTART("n", "Restart gry", false),
    QUIT("x", "Koniec gry", false),
    NOT_DEFINED("", "Nie zdefiniowany", false);
    
    private final String moveButton;
    private final String moveName;
    private final boolean movable;
    
    CommandEnum(String moveButton, String moveName, boolean evaluatable) {
        this.moveButton = moveButton;
        this.moveName = moveName;
        this.movable = evaluatable;
    }
    
    public String getMoveButton() {
        return this.moveButton;
    }
    
    public String getMoveName() {
        return this.moveName;
    }

    public boolean isMovable() {
        return this.movable;
    }
    
    public static CommandEnum findByMoveButton(String moveNumber) {
        return Arrays.asList(values()).stream().filter(x -> x.getMoveButton().equals(moveNumber)).findFirst().orElse(NOT_DEFINED);
    }
    
    public static List<CommandEnum> getAllMovable() {
        return Arrays.asList(values()).stream().filter(x -> x.isMovable()).collect(Collectors.toList());
    }
}
