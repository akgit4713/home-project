package com.homeproject.homeproject.ChessDesign;

import ch.qos.logback.core.pattern.color.ANSIConstants;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Player player1 = Player.builder().name("ANURAG").color(Color.WHITE).build();
        Player player2 = Player.builder().name("UTKARSH").color(Color.WHITE).build();
        Board board = Board.getInstance();
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 0;
        //Implement checkmate, check next
        while (currentPlayer<=8){
            System.out.println( player1.getName() + " Enter the to and fro position where you want to move ");
            Board.printChessBoard();
            int a,b,x,y;
            a=sc.nextInt();
            b=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
            try {
                if (currentPlayer % 2 == 0) {
                    player1.move(a, b, x, y);
                } else {
                    player2.move(a, b, x, y);
                }
                currentPlayer++;
            }
            catch (Exception e){
                System.out.println("INVALID!! TRY AGAIN");
            }
        }
    }
}
