package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure islands.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.

Example:

Input:
[['S', 'O', 'O', 'S', 'S'],
 ['D', 'O', 'D', 'O', 'D'],
 ['O', 'O', 'O', 'O', 'X'],
 ['X', 'D', 'D', 'O', 'O'],
 ['X', 'D', 'D', 'D', 'O']]

Output: 3
Explanation:
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 */
public class TreasureIslandII {
    public static int minDist(char[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        for(int i =0; i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 'S'){
                    queue.add(new Position(i,j));
                }
            }
        }

        int step =0;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        while (!queue.isEmpty()){
            for (int sz = queue.size(); sz > 0; sz--) {
                Position position = queue.poll();
                if (grid[position.r][position.c] == 'X') return step;
                grid[position.r][position.c] = 'D';
                for (int[] dir : dirs) {
                    int x = position.r + dir[0];
                    int y = position.c + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'D') {
                        queue.offer(new Position(x, y));
                    }
                }
            }
            step++;

        }
        return -1;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(minDist(grid));    }

}
