package main.java.topcodingquestion.systemdesign.chess;

public class Pawn extends Piece {
    public Pawn(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
