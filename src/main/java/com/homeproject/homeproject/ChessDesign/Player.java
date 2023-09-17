package com.homeproject.homeproject.ChessDesign;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Player {
    private  String name;
    private  Color color;
    public void move(Integer sx, Integer sy, Integer ex, Integer ey){
        System.out.println("Going to move");
        Board board = Board.getInstance();
        if (Objects.requireNonNull(Board.getPiece(sx, sy)).getColor() != this.color)
            throw new ChessException("Invalid Color!!!");
        board.movePiece(this, sx, sy, ex, ey);
    }
}
