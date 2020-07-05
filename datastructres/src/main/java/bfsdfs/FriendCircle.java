package main.java.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are N students in a class. Some of them are friends,
 * while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C,
 * then A is an indirect friend of C. And we defined a friend circle
 * is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students
 * are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 */
public class FriendCircle {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        int[] visited = new int[m];
        Queue<Integer> queue = new LinkedList<>();
        int connComp=0;
        for(int i =0;i<m;i++){
            if(visited[i] ==0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int s = queue.remove();
                    visited[s] =1;
                    for (int j =0;j < m;j++){
                        if(M[s][j] == 1 && visited[j]==0){
                            queue.add(j);
                        }
                    }
                    connComp++;
                }
            }

        }
        return connComp;
    }
}
