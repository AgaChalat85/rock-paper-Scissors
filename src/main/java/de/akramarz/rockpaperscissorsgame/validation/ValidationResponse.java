package de.akramarz.rockpaperscissorsgame.validation;

public class ValidationResponse {
    
    private final boolean valid;
    private final String warning;

    public ValidationResponse(boolean valid, String warning) {
        this.valid = valid;
        this.warning = warning;
    }

    public boolean isValid() {
        return valid;
    }

    public String getWarning() {
        return warning;
    }

    @Override
    public String toString() {
        return "ValidationResponse{" + "valid=" + valid + ", warning=" + warning + '}';
    }
}
