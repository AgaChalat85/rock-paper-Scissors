package com.kodilla.rockpaperscissorsgame.moves;

import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;

public class MovesCombination {
    
    private final CommandEnum playerMove;
    private final CommandEnum computerMove;
    
    public MovesCombination(CommandEnum playerMove, CommandEnum computerMove) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
    }

    @Override
    public int hashCode() {
        int hash = this.playerMove.getMoveButton().hashCode() - this.computerMove.getMoveButton().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovesCombination other = (MovesCombination) obj;
        if (this.playerMove != other.playerMove) {
            return false;
        }
        if (this.computerMove != other.computerMove) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovesCombination{" + "playerMove=" + playerMove + ", computerMove=" + computerMove + '}';
    }
}
