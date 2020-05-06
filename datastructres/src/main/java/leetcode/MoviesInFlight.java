package main.java.leetcode;

import java.util.*;

public class MoviesInFlight {


    private static int[] findMovies(int[] movie_duration, int d) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<movie_duration.length;i++) {
            map.putIfAbsent(movie_duration[i], new ArrayList<>());
            map.get(movie_duration[i]).add(i);
        }
        Arrays.sort(movie_duration);
        int l = 0, r = movie_duration.length - 1;
        int max = 0;
        d-=30;
        int[] res = new int[]{-1, -1};
        while(l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if((sum > max || (sum == max && Math.max(movie_duration[l] , movie_duration[r]) > Math.max(res[0],  res[1]))) && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if(sum > d)
                r--;
            else
                l++;
        }
        if(map.get(res[0]) == map.get(res[1])) {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(1);
        }else {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(0);
        }
        for (int i:res){
            System.out.println(i);
        }
        return res;
    }
    public static void main(String[] args) {
        //System.out.println(findMovies(new int[]{90, 85, 75, 60, 120, 150, 125}, 250));
        //System.out.println(findMovies(new int[]{90, 85, 75, 60, 155, 150, 125}, 250));
        System.out.println(findMovies(new int[]{90, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
        System.out.println(findMovies(new int[]{95, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
        System.out.println(findMovies(new int[]{1, 10, 25, 35, 60}, 90));
        System.out.println(findMovies(new int[]{20, 50, 40, 25, 30, 10}, 90));
        System.out.println(findMovies(new int[]{5, 55, 40, 20, 30, 30}, 90));
    }
}
