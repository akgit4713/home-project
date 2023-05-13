package com.homeproject.homeproject.SnakeAndLadders;


public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Board board = Board.getInstance();
        Board board1 = Board.getInstance();
        int currentPlayer = 0;
        while (!board.isGameOver()) {
            Player player = board.getCurrentPlayer(currentPlayer);
            int resulOfRoll = player.roll(6);
            System.out.println((currentPlayer == 0 ? ANSI_GREEN : ANSI_RED) + player.getName() + " Your Result of Roll is " + resulOfRoll);
            player.movePlayer(resulOfRoll);
            System.out.println(player.getName() + " Your piece is now at " + player.getPosition());
            ++currentPlayer;
            currentPlayer %= 2;
        }
        System.out.println("The Winner of the Game is " + board.getCurrentPlayer((++currentPlayer) % 2).getName());
    }
}
