package com.homeproject.homeproject.SnakeAndLadders;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board= Board.getInstance();
        int currentPlayer = 0;

        while (!board.isGameOver()){
            Player player = board.getCurrentPlayer(currentPlayer);
            int resulOfRoll =player.roll(6);
            System.out.println(" Your Result of Roll is "+ resulOfRoll);
            player.movePlayer(resulOfRoll);
            System.out.println(player.getName()+" Your piece is now at "+player.getPosition());
            ++currentPlayer;
            currentPlayer %= 2;
        }
        System.out.println("The Winner of the Game is " +board.getCurrentPlayer((++currentPlayer) %2 ).getName());
    }
}
