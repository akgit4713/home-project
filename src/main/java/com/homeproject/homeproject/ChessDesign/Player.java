package com.homeproject.homeproject.ChessDesign;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Player {
    private  String name;
    private  Color color;
    public void move(Integer sx, Integer sy, Integer ex, Integer ey){
        System.out.println("Going to move");
        Board board = Board.getInstance();
        board.movePiece(this, sx, sy, ex, ey);
    }
}
