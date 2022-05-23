package de.akramarz.rockpaperscissorsgame.enums;

public enum ConfirmationEnum {
    YES("T"),
    NO("N");
    
    private final String value;
    
    private ConfirmationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    } 
}
