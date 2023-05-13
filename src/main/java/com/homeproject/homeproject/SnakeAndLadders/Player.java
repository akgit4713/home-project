package com.homeproject.homeproject.SnakeAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Player implements Dice {
    private final String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public int roll(int size) {
        // Logic to roll
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    public void movePlayer(int moves) {
        if (Board.getInstance().isLadder(position + moves) || Board.getInstance().isSnake(position + moves))
            position = newPositionAfterJump(position + moves);
        else
            this.position += moves;
    }

    private int newPositionAfterJump(int i) {
        return Board.snakeAndLadderMap.get(i);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
