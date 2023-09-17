package com.homeproject.homeproject.ChessDesign;

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
            if (pieceType.equals(PieceType.BISHOP)) {
                return checkBishop(sx, sy, ex, ey) && check;
            } else if (pieceType.equals(PieceType.KNIGHT)) {
                if (abs(ex - sx) == 1) {
                    return abs(ey - sy) == 2 && check;
                } else if (abs(ex - sx) == 2) {
                    return abs(ey - sy) == 1 && check;
                } else {
                    return false;
                }
            } else {
                if (pieceType.equals(PieceType.ROOK)) {
                    return checkRook(sx, sy, ex, ey) && check;
                } else if (pieceType.equals(PieceType.QUEEN)) {
                    return (checkRook(sx, sy, ex, ey) || checkBishop(sx, sy, ex, ey)) && check;
                } else if (pieceType.equals(PieceType.PAWN)) {
                    return abs(ey - sy) > 0 && abs(ex - sx) == 0 || (ey - sy == 1 && abs(ex - sx) == 1 && check);
                } else {
                    throw new ChessException("Invalid move");
                }
            }
        }
        return false;
    }

    public boolean checkBishop(Integer sx, Integer sy, Integer ex, Integer ey){
        int x = sx, y= sy, X=ex, Y=ey;
        boolean b = abs(X - x) == abs(Y - y);
        if(b){
            if(X>x){
                if(Y>y){
                    while(x!=X && y!=Y){
                        x++;
                        y++;
                        if(x!=X && y!=Y &&Board.getPiece(x,y)!=null)
                            return false;
                    }
                    return true;
                }
                else{
                    while(x!=X && y!=Y){
                        ++x;
                        --y;
                        if(x!=X && y!=Y &&Board.getPiece(x,y)!=null)
                            return false;
                    }
                    return true;
                }
            }
            else {
                if(Y>y){
                    while(x!=X && y!=Y){
                        --x;
                        y++;
                        if(x!=X && y!=Y &&Board.getPiece(x,y)!=null)
                            return false;
                    }
                    return true;
                }
                else{
                    while(x!=X && y!=Y){
                        --x;
                        --y;
                        if(x!=X && y!=Y &&Board.getPiece(x,y)!=null)
                            return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRook(Integer sx, Integer sy, Integer ex, Integer ey) {
        int x = sx, y = sy, X = ex, Y = ey;
        boolean check = abs(y - Y) == 0 && abs(x - X) > 0 || (abs(x - X) == 0 && abs(y - Y) > 0);
        if (check) {
            if (abs(x - X) > 0) {
                if (X > x) {
                    while (x != X) {
                        ++x;
                        if (x != X) {
                            if (Board.getPiece(x, y) != null)
                                return false;
                        }
                    }
                    return true;
                } else {
                    while (x != X) {
                        --x;
                        if (x != X) {
                            if (Board.getPiece(x, y) != null)
                                return false;
                        }
                    }
                    return true;
                }
            } else {
                if (Y > y) {
                    while (y != Y) {
                        ++y;
                        if (y != Y) {
                            if (Board.getPiece(x, y) != null)
                                return false;
                        }
                    }
                    return true;
                } else {
                    while (y != Y) {
                        --y;
                        if (y != Y) {
                            if (Board.getPiece(x, y) != null)
                                return false;
                        }
                    }
                    return true;
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
