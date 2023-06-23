package com.homeproject.homeproject.ChessDesign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Board {
    public static final int size = 8;
    private static ArrayList<Piece> boardSetup = new ArrayList<>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static List<Player> players = new ArrayList<>();

    private Board() {
        setupBoardForGameplay();
    }

    public static void setBoardSetup(ArrayList<Piece> boardSetup) {
        Board.boardSetup = boardSetup;
    }

    public static Piece getPiece(Integer x, Integer y) {
        for (Piece curPiece : boardSetup) {
            if (Objects.equals(curPiece.getPosX(), x) && Objects.equals(curPiece.getPosY(), y) && curPiece.getPieceState().equals(PieceState.ACTIVE))
                return curPiece;
        }
        return null;
    }

    public static Board getInstance() {
        return BoardImpl.board;
    }

    private void setupBoardForGameplay() {
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType == PieceType.KING) {
                boardSetup.add(Piece.builder().posY(5).posX(1).color(Color.WHITE).pieceType(PieceType.KING).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(5).posX(8).color(Color.BLACK).pieceType(PieceType.KING).pieceState(PieceState.ACTIVE).build());
            } else if (pieceType == PieceType.PAWN) {
                for (int i = 1; i <= size; i++) {
                    boardSetup.add(Piece.builder().posY(i).posX(2).color(Color.WHITE).pieceType(PieceType.PAWN).pieceState(PieceState.ACTIVE).build());
                    boardSetup.add(Piece.builder().posY(i).posX(7).color(Color.BLACK).pieceType(PieceType.PAWN).pieceState(PieceState.ACTIVE).build());
                }
            } else if (pieceType == PieceType.BISHOP) {
                boardSetup.add(Piece.builder().posY(3).posX(1).color(Color.WHITE).pieceType(PieceType.BISHOP).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(6).posX(1).color(Color.WHITE).pieceType(PieceType.BISHOP).pieceState(PieceState.ACTIVE).build());

                boardSetup.add(Piece.builder().posY(3).posX(8).color(Color.BLACK).pieceType(PieceType.BISHOP).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(6).posX(8).color(Color.BLACK).pieceType(PieceType.BISHOP).pieceState(PieceState.ACTIVE).build());

            } else if (pieceType == PieceType.KNIGHT) {
                boardSetup.add(Piece.builder().posY(2).posX(1).color(Color.WHITE).pieceType(PieceType.KNIGHT).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(7).posX(1).color(Color.WHITE).pieceType(PieceType.KNIGHT).pieceState(PieceState.ACTIVE).build());

                boardSetup.add(Piece.builder().posY(2).posX(8).color(Color.BLACK).pieceType(PieceType.KNIGHT).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(7).posX(8).color(Color.BLACK).pieceType(PieceType.KNIGHT).pieceState(PieceState.ACTIVE).build());
            } else if (pieceType == PieceType.ROOK) {

                boardSetup.add(Piece.builder().posY(1).posX(1).color(Color.WHITE).pieceType(PieceType.ROOK).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(8).posX(1).color(Color.WHITE).pieceType(PieceType.ROOK).pieceState(PieceState.ACTIVE).build());

                boardSetup.add(Piece.builder().posY(1).posX(8).color(Color.BLACK).pieceType(PieceType.ROOK).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(8).posX(8).color(Color.BLACK).pieceType(PieceType.ROOK).pieceState(PieceState.ACTIVE).build());
            } else if (pieceType == PieceType.QUEEN) {
                boardSetup.add(Piece.builder().posY(4).posX(1).color(Color.WHITE).pieceType(PieceType.QUEEN).pieceState(PieceState.ACTIVE).build());
                boardSetup.add(Piece.builder().posY(4).posX(8).color(Color.BLACK).pieceType(PieceType.QUEEN).pieceState(PieceState.ACTIVE).build());
            }
        }
    }

    public void movePiece(Player player,Integer sx, Integer sy, Integer ex, Integer ey) {
        Piece piece = getPiece(sx,sy);
        if(piece == null)
            throw new ChessException("Invalid MOVE");
        piece.movePiece(player,sx,sy,ex,ey);
    }

    private static class BoardImpl {
        private static final Board board = new Board();

    }
    public static void setPlayer(Player player){
        players.add(player);
    }

    public static void printChessBoard(){
        for (int i=1;i<=size;i++){
            for (int j=1;j<=size;j++){
                if(getPiece(i,j)==null)
                    System.out.print("\t");
                else
                    System.out.print( ANSI_GREEN + Objects.requireNonNull(getPiece(i, j)).getPieceType()+"\t");
            }
            System.out.println();
        }
    }

}
