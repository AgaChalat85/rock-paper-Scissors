package de.akramarz.rockpaperscissorsgame.moves;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import static de.akramarz.rockpaperscissorsgame.enums.ResultsEnum.*;
import static de.akramarz.rockpaperscissorsgame.enums.MovesEnum.*;

import de.akramarz.rockpaperscissorsgame.enums.ResultsEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MovesEvaluator {
    
    private final static Map<MovesCombination, ResultsEnum> MOVES_COMBINATION_TO_RESULT_MAPPING;
    
    static {
        MOVES_COMBINATION_TO_RESULT_MAPPING = new HashMap<>();
        
        // Player wins
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(ROCK, SCISSORS), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SCISSORS, PAPER), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(PAPER, ROCK), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(ROCK, LIZARD), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(LIZARD, SPOCK), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SPOCK, SCISSORS), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SCISSORS, LIZARD), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(LIZARD, PAPER), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(PAPER, SPOCK), PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SPOCK, ROCK), PLAYER_WINS);
        
        // Computer wins
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SCISSORS, ROCK), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(PAPER, SCISSORS), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(ROCK, PAPER), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(LIZARD, ROCK), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SPOCK, LIZARD), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SCISSORS, SPOCK), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(LIZARD, SCISSORS), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(PAPER, LIZARD), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SPOCK, PAPER), COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(ROCK, SPOCK), COMPUTER_WINS);
        
        // Draws
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(ROCK, ROCK), DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(PAPER, PAPER), DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SCISSORS, SCISSORS), DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(LIZARD, LIZARD), DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(SPOCK, SPOCK), DRAW);
    }
    
    public Optional<ResultsEnum> evaulate(MovesEnum playerMove, MovesEnum computerMove) {
        MovesCombination movesCombination = new MovesCombination(playerMove, computerMove);
        ResultsEnum result = MOVES_COMBINATION_TO_RESULT_MAPPING.get(movesCombination);
        
        return Optional.ofNullable(result);
    }
}
