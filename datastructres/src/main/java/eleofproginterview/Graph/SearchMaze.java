package main.java.eleofproginterview.Graph;

import java.util.ArrayList;
import java.util.List;

public class SearchMaze {
    public static enum Color { WHITE, BLACK }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s,
                                              Coordinate e){
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y,Color.BLACK);
        path.add(s);
        if(!searchMazeHelper(maze,s,e,path)){
            path.remove(path.size() -1);
        }
        return path; // Empty path means no path between s and e
    }

    private static boolean searchMazeHelper(List<List<Color>> maze,Coordinate curr, Coordinate e,
                                            List<Coordinate> path){
        if(curr.equals(e)){
            return true;
        }
        final int[][] SHIFT = {{-1,0},{0,-1},{1,0},{0,1}};
        for (int[] s : SHIFT){
            Coordinate next = new Coordinate(curr.x + s[0],curr.y + s[1]);
            if(isFeasible(next,maze)){
                maze.get(next.x).set(next.y,Color.BLACK);
                path.add(next);
                if(searchMazeHelper(maze,next,e,path)){
                    return true;
                }
                // Remove the previous step from the solution
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private static boolean isFeasible(Coordinate curr, List<List<Color>> maze){
        return curr.x >=0 && curr.x < maze.size() && curr.y >=0
                && curr.y < maze.get(0).size()
                && maze.get(curr.x).get(curr.y) == Color.WHITE;
    }

    public static void main(String[] args) {
        List<List<Color>> maze = new ArrayList<>();
        List<Color> row = new ArrayList<>();
        row.add(Color.BLACK);
        row.add(Color.WHITE);
        row.add(Color.WHITE);
        row.add(Color.WHITE);
        maze.add(row);
        row = new ArrayList<>();
        row.add(Color.WHITE);
        row.add(Color.BLACK);
        row.add(Color.WHITE);
        row.add(Color.BLACK);
        maze.add(row);
        row = new ArrayList<>();
        row.add(Color.WHITE);
        row.add(Color.WHITE);
        row.add(Color.WHITE);
        row.add(Color.BLACK);
        maze.add(row);
        row = new ArrayList<>();
        row.add(Color.WHITE);
        row.add(Color.WHITE);
        row.add(Color.BLACK);
        row.add(Color.BLACK);
        maze.add(row);
        Coordinate start = new Coordinate(3,0);
        Coordinate end = new Coordinate(0,3);
        List<Coordinate> path = searchMaze(maze,start,end);
        for (Coordinate coordinate : path){
            System.out.println("X : "+coordinate.x +",Y : "+coordinate.y);
        }

    }
}
