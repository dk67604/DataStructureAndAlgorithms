package main.java.topcodingquestion.systemdesign.chess;

public class Bishop extends Piece{
    public Bishop(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
