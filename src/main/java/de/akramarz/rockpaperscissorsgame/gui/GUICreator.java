package de.akramarz.rockpaperscissorsgame.gui;

import static de.akramarz.rockpaperscissorsgame.enums.MovesEnum.*;

import de.akramarz.rockpaperscissorsgame.enums.MovesEnum;
import de.akramarz.rockpaperscissorsgame.round.Round;
import de.akramarz.rockpaperscissorsgame.score.Score;
import java.util.List;
import java.util.Scanner;

public class GUICreator {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MOVE_TEMPLATE = "(%s) -> %s";
    
    public static String getHumanPlayerName() {
        System.out.println("Podaj imie gracza: ");
        String name = SCANNER.nextLine();
        return name;
    }
    
    public static String getRoundsNumber() {
        System.out.println("Podaj liczbe rund: ");
        String roundsNumber = SCANNER.nextLine();
        return roundsNumber;
    }
    
    public static void showUserManuals() {
        List<MovesEnum> playerMoves = MovesEnum.getAllEvaluatable();
        System.out.println("-------------------------------------------");
        System.out.println("--Wykonaj ruch, zresetuj albo zakoncz gre--");
        System.out.println("-------------------------------------------");
        
        playerMoves.stream().map((move) -> String.format(MOVE_TEMPLATE, move.getMoveButton(), move.getMoveName())).forEachOrdered(moveString -> System.out.println(moveString));
        
        System.out.println("-------------------------------------------");
        System.out.println("---------------Opcje-----------------------");
        System.out.println(String.format(MOVE_TEMPLATE, QUIT.getMoveButton(), QUIT.getMoveName()));
        System.out.println(String.format(MOVE_TEMPLATE, RESTART.getMoveButton(), RESTART.getMoveName()));
    }
    
    public static String makePlayerMove() {
        System.out.println("Wykonaj swoj ruch: ");
        String playerMove = SCANNER.nextLine();
        return playerMove;
    }
    
    public static void showRoundSummary(Round round) {
        System.out.println("-------------------------------------------");
        System.out.println("Gracz wybral: " + round.getPlayerMove().getMoveName());
        System.out.println("Komputer wybral: " + round.getComputerMove().getMoveName());
        System.out.println("Wynik tej rundy: " + round.getResult().getDescription());
    }
    
    public static void showScore(Score score) {
        System.out.println("-------------------------------------------");
        System.out.println("Wygrane rundy gracza:     " + score.getHumanScore());
        System.out.println("Wygrane rundy komputera : " + score.getComputerScore());
        System.out.println("Remisy:                   " + score.getDraws());
    }
    
    public static String getRestartConfirmation() {
        System.out.println("Czy na pewno zakonczyc aktualna gre? (T/N)");
        String confirmation = SCANNER.nextLine();
        return confirmation;
    }
    
    public static String getQuitConfirmation() {
       System.out.println("Czy na pewno zakonczyc gre? (T/N)");
       String confirmation = SCANNER.nextLine();
       return confirmation;
    }
}
