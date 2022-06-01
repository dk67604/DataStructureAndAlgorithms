package main.java.topcodingquestion.systemdesign.chess;

public class Rook extends Piece{
    public Rook(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
