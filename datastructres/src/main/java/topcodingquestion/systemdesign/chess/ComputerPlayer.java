package main.java.topcodingquestion.systemdesign.chess;

public class ComputerPlayer extends Player{
    public ComputerPlayer(boolean whiteSide){
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
}
