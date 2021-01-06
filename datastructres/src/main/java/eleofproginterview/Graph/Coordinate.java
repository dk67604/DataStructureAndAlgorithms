package main.java.eleofproginterview.Graph;

import java.util.Objects;

public class Coordinate {
    public int x,y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if(obj == null || getClass() !=obj.getClass()){
            return false;
        }
        Coordinate that = (Coordinate)obj;
        if(x != that.x || y != that.y){
            return false;
        }
        return true;
    }
}
