package main.java.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public static int friendCircle(int[][] M) {
        int m = M.length;
        int[] visited = new int[m];
        Queue<Integer> queue = new LinkedList<>();
        int connComp = 0;
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < m; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                connComp++;
            }

        }
        return connComp;
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static int helper(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public static int countGroups(List<String> related) {
        int friendsSize = related.get(0).length();
        int[][] F = new int[friendsSize][friendsSize];
        for (int i = 0; i < friendsSize; i++) {
            String row = related.get(i);
            for (int j = 0; j < row.length(); j++) {
                F[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        return friendCircle(F);
    }

    public static void main(String[] args) {
        List<String> related = new ArrayList<>();
        related.add("1100");
        related.add("1110");
        related.add("0110");
        related.add("0001");
        System.out.println(countGroups(related));
    }
}
