package main.java.topcodingquestion.systemdesign.chess;

public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public Piece(boolean white) {
        this.white = white;
    }
    public abstract boolean canMove(Board board, Spot start, Spot end);



}
