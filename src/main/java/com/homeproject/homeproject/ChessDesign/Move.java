package com.homeproject.homeproject.ChessDesign;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

import static java.lang.Math.abs;

public class Move {
    private final Player player;
    private  final Piece piece;
    public Move(Player player, Piece piece){

        this.player = player;
        this.piece = piece;
    }

    public boolean canMovePiece(PieceType pieceType, Integer sx, Integer sy, Integer ex, Integer ey, Color color) {
        if (!inside(ex, ey) || Objects.requireNonNull(Board.getPiece(sx, sy)).getPieceState().equals(PieceState.INACTIVE))
            return false;
        boolean check = isNextPiecePresentAndColorCheck(ex, ey, color);
        if (pieceType.equals(PieceType.KING)) {
            if (ex - sx > 1 || ey - sy > 1)
                return false;
        } else {
            boolean b = abs(ex - sx) == abs(ey - sy);
            if (pieceType.equals(PieceType.BISHOP)) {
                return b && check;
            } else if (pieceType.equals(PieceType.KNIGHT)) {
                if (abs(ex - sx) == 1) {
                    return abs(ey - sy) == 2 && check;
                } else if (abs(ex - sx) == 2) {
                    return abs(ey - sy) == 1 && check;
                } else {
                    return false;
                }
            } else {
                boolean b1 = abs(sy - ey) == 0 && abs(sx - ex) > 0;
                if (pieceType.equals(PieceType.ROOK)) {
                    return (abs(sx - ex) == 0 && abs(sy - ey) > 0) || b1 && check;
                } else if (pieceType.equals(PieceType.QUEEN)) {
                    return (b || (abs(ex - sx) == 0 && abs(sy - ey) > 0) || b1) && check;
                } else if (pieceType.equals(PieceType.PAWN)) {
                    return abs(ey - sy) > 0 && abs(ex - sx) == 0 || (ey - sy == 1 && abs(ex - sx) == 1 && check);
                } else {
                    throw new ChessException("Invalid move");
                }
            }
        }
        return false;
    }

    public boolean isNextPiecePresentAndColorCheck(Integer x, Integer y, Color color) {
        Piece nxtPiece = Board.getPiece(x, y);
        if (nxtPiece == null) {
            return true;
        } else {
            return nxtPiece.getColor() != color;
        }
    }

    public void moveAndChangeState(Piece piece, Integer ex, Integer ey) {
        Piece nxtPiece = Board.getPiece(ex, ey);
        System.out.println("Next Piece "+nxtPiece);
        if (nxtPiece != null) {
            System.out.println("Next piece is set inactive"+nxtPiece);
            nxtPiece.setPieceState(PieceState.INACTIVE);
        }
        piece.setPosX(ex);
        piece.setPosY(ey);
    }

    private boolean inside(Integer ex, Integer ey) {
        return ex >= 1 && ex <= Board.size && ey >= 1 && ey <= Board.size;
    }

}
