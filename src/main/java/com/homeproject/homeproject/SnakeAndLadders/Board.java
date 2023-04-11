package com.homeproject.homeproject.SnakeAndLadders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    public static HashMap<Integer, Integer> snakeAndLadderMap;
    public List<Player> playerList= new ArrayList<>();
    private Board(){
        snakeAndLadderMap = new HashMap<>();
        //Ladders
        snakeAndLadderMap.put(5, 9);
        snakeAndLadderMap.put(10, 20);
        snakeAndLadderMap.put(50, 60);
        snakeAndLadderMap.put(25, 93);
        snakeAndLadderMap.put(24, 77);
        snakeAndLadderMap.put(33,69);
        snakeAndLadderMap.put(42,85);

        //Snakes
        snakeAndLadderMap.put(18, 11);
        snakeAndLadderMap.put(20, 5);
        snakeAndLadderMap.put(77, 61);
        snakeAndLadderMap.put(82, 22);
        snakeAndLadderMap.put(67, 51);
        snakeAndLadderMap.put(98, 2);
        snakeAndLadderMap.put(66, 17);

        playerList.add(new Player("PlayerA",0));
        playerList.add(new Player("PlayerB",0));
    }
    private static class BoardImpl{
        private static final Board board = new Board();
    }
    public static Board getInstance(){
        return BoardImpl.board;
    }

    public boolean isSnake(int x){
        if(snakeAndLadderMap.containsKey(x) && snakeAndLadderMap.get(x) < x){
            System.out.println("$$$$$$ You got a snake at "+ x);
            return true;
        }
        return false;
    }

    public boolean isLadder(int x){
        if (snakeAndLadderMap.containsKey(x) && snakeAndLadderMap.get(x) > x){
            System.out.println("###### You got a ladder at "+ x);
            return true;
        }
        return false;
    }

    public boolean isGameOver(){
        for( Player player : playerList){
            if(player.getPosition()>=100)
                return true;
        }
        return false;
    }

    public Player getCurrentPlayer( int index){
        return playerList.get(index);
    }
}
