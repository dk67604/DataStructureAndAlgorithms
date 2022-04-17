package main.java.bfsdfs;

import java.util.*;

public class Test {
    public void solution(String[] x, String[] y){
        Map<String, List<String>> map = new HashMap<>();
        for(int i =0;i<x.length;i++){
            if(!map.containsKey(x[i])){
                map.put(x[i],new ArrayList<>());
            }
            map.get(x[i]).add(y[i]);
        }
        String[] result = new String[x.length];
        for(int i =0;i<x.length;i++){
            Set<String> visited = new HashSet<>();
            int count = helper(map,visited,x[i]);
            result[i] = x[i] + " " + count;
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    private int helper(Map<String,List<String>> map, Set<String> visited,String start){
        int count =0;
        if(map.containsKey(start)){
            for(String child : map.get(start)){
                count+=1;
                if(!visited.contains(child)){
                    count += helper(map,visited,child);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.solution(new String[]{"A","B","C"}, new String[]{"B","C","D"});
        test.solution(new String[]{"S","Q","R","P"}, new String[]{"P","S","D","A"});
    }
}
