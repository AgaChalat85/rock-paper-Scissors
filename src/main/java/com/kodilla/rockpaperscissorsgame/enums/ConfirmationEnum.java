package com.kodilla.rockpaperscissorsgame.enums;

public enum ConfirmationEnum {
    YES("T"),
    NO("N");
    
    private final String value;

    ConfirmationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    } 
}
