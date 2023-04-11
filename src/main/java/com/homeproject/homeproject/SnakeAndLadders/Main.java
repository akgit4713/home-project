package com.homeproject.homeproject.SnakeAndLadders;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Board board= Board.getInstance();
        int currentPlayer = 0;
        while (!board.isGameOver()){
            Player player = board.getCurrentPlayer(currentPlayer);
            int resulOfRoll = player.roll(6);
            System.out.println((currentPlayer == 0 ?ANSI_GREEN:ANSI_RED)+ player.getName()+" Your Result of Roll is "+ resulOfRoll);
            player.movePlayer(resulOfRoll);
            System.out.println(player.getName()+" Your piece is now at "+player.getPosition());
            ++currentPlayer;
            currentPlayer %= 2;
        }
        System.out.println("The Winner of the Game is " +board.getCurrentPlayer((++currentPlayer) %2 ).getName());
    }
}
