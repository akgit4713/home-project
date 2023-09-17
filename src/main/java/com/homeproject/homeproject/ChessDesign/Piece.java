package com.homeproject.homeproject.ChessDesign;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Piece {
    private  Color color;
    private  Integer posX;
    private  Integer posY;
    private  PieceType pieceType;
    private  PieceState pieceState;
    private  Move move ;


    public void movePiece(Player player, Integer sx, Integer sy, Integer ex, Integer ey) {
        Piece curPiece = Board.getPiece(sx, sy);
        System.out.println("Current piece "+curPiece);
        assert curPiece != null;
        move = new Move(player,curPiece);
        boolean canMove = move.canMovePiece(curPiece.getPieceType(), sx, sy, ex, ey, curPiece.color);
        if (canMove) {
            System.out.println("Going to move");
            move.moveAndChangeState(curPiece, ex, ey);
        }
    }
}
