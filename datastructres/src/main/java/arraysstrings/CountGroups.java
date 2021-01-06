package main.java.arraysstrings;

import java.util.*;

public class CountGroups {
    public static int countGroups(List<String> related) {
        int[][] M = new int[related.size()][related.size()];
        for (int i = 0; i< related.size();i++){
            String temp = related.get(i);

            for(int j =0; j< temp.length();j++){
                M[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        return findCircleNum(M);
    }

    public static int findCircleNum(int[][] M) {
        int m = M.length;
        int[] visited = new int[m];
        Queue<Integer> queue = new LinkedList<>();
        int connComp=0;
        for(int i =0;i<m;i++){
            if(visited[i] ==0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j =0;j < m;j++){
                        if(M[s][j] == 1 && visited[j]==0){
                            queue.add(j);
                        }
                    }
                }
                connComp++;
            }

        }
        return connComp;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1100");
        input.add("1110");
        input.add("0110");
        input.add("0001");
        System.out.println(countGroups(input));

    }

}
