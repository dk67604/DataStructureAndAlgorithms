package main.java.topcodingquestion.systemdesign.chess;

public class King  extends Piece{
    private boolean castlingDone = false;
    public King( boolean white){
        super(white);
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    private boolean isValidCastling(Board board,
                                    Spot start, Spot end)
    {

        if (this.isCastlingDone()) {
            return false;
        }

        // Logic for returning true or false
        return true;
    }

    public boolean isCastlingMove(Spot start, Spot end)
    {
        // check if the starting and
        // ending position are correct
        return true;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1){
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }
        return this.isValidCastling(board, start, end);
    }

    public boolean isCastlingMove() {
        return true;
    }
}
