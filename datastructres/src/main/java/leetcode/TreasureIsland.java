package main.java.leetcode;

/*
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid,
represented by a matrix of characters.
You must start from the top-left corner of the map and can move one block up,
down, left or right at a time. The treasure island is marked as X in a block of the matrix.
X will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as D.
You must not enter dangerous blocks. You cannot leave the map area.
Other areas O are safe to sail in. The top-left corner is always safe.
Output the minimum number of steps to get to the treasure.

Example:

Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */

import java.util.LinkedList;
import java.util.Queue;

class  Position{
    int r,c;
    Position(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class TreasureIsland {
    public static int minSteps(char[][] grid) {
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0));
        grid[0][0] = 'D';
        int step =1;
        while (!queue.isEmpty()){

            for (int sz = queue.size(); sz > 0; sz--) {
                Position position = queue.poll();
                for (int[] dir : dirs) {
                    int x = position.r + dir[0];
                    int y = position.c + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'D') {
                        if (grid[x][y] == 'X') return step;
                        grid[x][y] = 'D';
                        queue.offer(new Position(x, y));
                    }
                }
            }
            step++;

        }
        return -1;
    }
    public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        System.out.println(minSteps(grid));
    }
}
