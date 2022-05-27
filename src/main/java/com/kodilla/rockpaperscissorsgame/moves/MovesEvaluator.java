package com.kodilla.rockpaperscissorsgame.moves;

import com.kodilla.rockpaperscissorsgame.enums.CommandEnum;
import com.kodilla.rockpaperscissorsgame.enums.ResultsEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MovesEvaluator {
    
    private final static Map<MovesCombination, ResultsEnum> MOVES_COMBINATION_TO_RESULT_MAPPING;
    
    static {
        MOVES_COMBINATION_TO_RESULT_MAPPING = new HashMap<>();
        
        // Player wins
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.ROCK, CommandEnum.SCISSORS), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SCISSORS, CommandEnum.PAPER), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.PAPER, CommandEnum.ROCK), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.ROCK, CommandEnum.LIZARD), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.LIZARD, CommandEnum.SPOCK), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SPOCK, CommandEnum.SCISSORS), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SCISSORS, CommandEnum.LIZARD), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.LIZARD, CommandEnum.PAPER), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.PAPER, CommandEnum.SPOCK), ResultsEnum.PLAYER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SPOCK, CommandEnum.ROCK), ResultsEnum.PLAYER_WINS);
        
        // Computer wins
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SCISSORS, CommandEnum.ROCK), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.PAPER, CommandEnum.SCISSORS), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.ROCK, CommandEnum.PAPER), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.LIZARD, CommandEnum.ROCK), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SPOCK, CommandEnum.LIZARD), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SCISSORS, CommandEnum.SPOCK), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.LIZARD, CommandEnum.SCISSORS), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.PAPER, CommandEnum.LIZARD), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SPOCK, CommandEnum.PAPER), ResultsEnum.COMPUTER_WINS);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.ROCK, CommandEnum.SPOCK), ResultsEnum.COMPUTER_WINS);
        
        // Draws
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.ROCK, CommandEnum.ROCK), ResultsEnum.DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.PAPER, CommandEnum.PAPER), ResultsEnum.DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SCISSORS, CommandEnum.SCISSORS), ResultsEnum.DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.LIZARD, CommandEnum.LIZARD), ResultsEnum.DRAW);
        MOVES_COMBINATION_TO_RESULT_MAPPING.put(new MovesCombination(CommandEnum.SPOCK, CommandEnum.SPOCK), ResultsEnum.DRAW);
    }
    
    public Optional<ResultsEnum> getResult(CommandEnum playerMove, CommandEnum computerMove) {
        MovesCombination movesCombination = new MovesCombination(playerMove, computerMove);
        ResultsEnum result = MOVES_COMBINATION_TO_RESULT_MAPPING.get(movesCombination);
        
        return Optional.ofNullable(result);
    }
}
