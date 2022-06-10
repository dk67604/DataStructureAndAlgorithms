package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

public class MinimumMovesToPushBox {
    private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minPushBox(char[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        int[] player = null, box = null, target = null;
        for(int i =0; i< m; i++){
            for (int j =0; j < n; j++){
                if(grid[i][j] == 'S') player = new int[]{i,j};
                else if(grid[i][j] == 'B') box = new int[]{i,j};
                else if(grid[i][j] == 'T') target = new int[]{i,j};
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        Set<List<Integer>> seen = new HashSet<>();
        queue.offer(new int[]{box[0], box[1],player[0],player[1]});
        seen.add(new ArrayList<>(Arrays.asList(box[0], box[1],player[0],player[1])));
        while (!queue.isEmpty()){
            int size =queue.size();
            for (int i = size; i>0;i--){
                int[] e = queue.poll();
                box = new int[]{e[0],e[1]};
                player = new int[]{e[2],e[3]};
                if(Arrays.equals(box,target)) return ans;
                for (int[] dir : DIRS) {
                    int x = box[0] + dir[0], y = box[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != '#' &&
                            !seen.contains(new ArrayList<>(Arrays.asList(x, y, box[0], box[1]))) &&
                    canReach(grid, m, n, player, box, new int[]{box[0] - dir[0], box[1] - dir[1]}))
                    {
                        seen.add(new ArrayList<>(Arrays.asList(x, y, box[0], box[1])));
                        queue.offer(new int[]{x,y,box[0],box[1]});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private boolean canReach(char[][] grid, int m, int n, int[] player, int[] box, int[] des) {
        Queue<int[]> queue = new LinkedList<>();
        Set<List<Integer>> seen = new HashSet<>();
        queue.offer(player);
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (Arrays.equals(p, des)) return true;
            for (int[] dir : DIRS) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != '#' &&
                        !seen.contains(new ArrayList<>(Arrays.asList(x, y))) &&
                        !Arrays.equals(new int[]{x, y}, box)) {
                    seen.add(new ArrayList<>(Arrays.asList(x,y)));
                    queue.offer(new int[]{x,y});

                }

            }
        }
        return false;
    }
}
