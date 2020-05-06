package main.java.leetcode;

import java.util.*;

public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        for(List<String> account:accounts){
            String name="";
            for(String email:account){
                if(name == ""){
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email,x-> new HashSet<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1),x->new HashSet<String>()).add(email);
                emailToName.put(email,name);


            }
        }
        List<List<String>> ans =new ArrayList<>();
        Set<String> visited =new HashSet<>();
        for(String email : emailToName.keySet()){
            List<String> list = new ArrayList<>();
            if(visited.add(email)){
                dfs(graph,email,visited,list);
                Collections.sort(list);
                list.add(0,emailToName.get(email));
                ans.add(list);
            }

        }
        return  ans;
    }

    public void dfs(Map<String,Set<String>> graph,String email,Set<String> visited,List<String> list){
        list.add(email);
        for(String next: graph.get(email)){
            if(!visited.contains(next)){
                visited.add(next);
                dfs(graph,next,visited,list);
            }
        }

    }
}
