package main.java.leetcode;

import java.util.*;

/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
Return a list of ids of selected elements. If no pair is possible, return an empty list.
 */
public class OptimalUtilization {
    public List<int[]> solution(List<int[]> a, List<int[]> b, int target){
        Map<Integer, List<int[]>> map = new HashMap<>();//key is sum , value is list of ids from a and b.

        for (int i = 0; i < a.size(); i ++){
            for (int j = 0; j < b.size(); j ++){
                List<int[]> sums = map.getOrDefault(a.get(i)[1] + b.get(j)[1], new ArrayList<int[]>());
                sums.add(new int[] {a.get(i)[0], b.get(j)[0]});
                map.put(a.get(i)[1] + b.get(j)[1], sums);
            }
        }

        List<Integer> allSums = new ArrayList<>();
        for (Integer i : map.keySet()){
            if (i < target){
                allSums.add(i);
            } else if (i == target){
                return map.get(target);
            }
        }
        if (allSums.size() == 0){
            return new ArrayList<>();//target is less than every possible sums.
        }
        return map.get(Collections.max(allSums));
    }
    public static List<int[]> createInput(int[][] input){
        List<int[]> test = new ArrayList<>();
        for (int[] i:input){
            test.add(i);
        }
        return test;
    }
    public static void printAns(List<int[]> ans){
        for (int[] a:ans){
            System.out.print("["+a[0]+","+a[1]+"]");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        List <int[]> a= new ArrayList<>();
        a.add(new int[]{1, 2});
        a.add(new int[]{2,4});
        a.add(new int[]{3,6});
        List <int[]> b= new ArrayList<>();
        b.add(new int[]{1, 2});
        int target =7;
        OptimalUtilization optimalUtilization = new OptimalUtilization();
        List<int[]> ans = optimalUtilization.solution(a,b,target);
        printAns(ans);
        int[][] i1={{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] i2 ={{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int t1 = 10;
        printAns(optimalUtilization.solution(createInput(i1),createInput(i2),t1));

    }
}
