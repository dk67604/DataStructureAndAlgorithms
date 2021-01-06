package main.java.leetcode;

import java.util.*;
/*

    Given a list accounts, each element accounts[i] is a list of strings,
    where the first element accounts[i][0] is a name, and
    the rest of the elements are emails representing emails of the account.
    Now, we would like to merge these accounts.
    Two accounts definitely belong to the same person
    if there is some email that is common to both accounts.
    Note that even if two accounts have the same name,
    they may belong to different people as people could have the same name.
    A person can have any number of accounts initially,
    but all of their accounts definitely have the same name.
    After merging the accounts, return the accounts in
    the following format: the first element of each account is the name,
    and the rest of the elements are emails in sorted order.
    The accounts themselves can be returned in any order.
 */
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
    public static List<List<String>> createTest(String[][] test){
        List<List<String>> res = new ArrayList<>();
        for (String[] t: test){
           List<String> list = new ArrayList<>();
           for (String s:t){
               list.add(s);
           }
           res.add(list);
        }
        return res;
    }

    public List<List<String>> accountsMergeUnion(List<List<String>> accounts) {

            DSU dsu = new DSU(10001);
            Map<String,String> emailToName = new HashMap<>();
            Map<String,Integer> emailToId = new HashMap<>();
            int id =0;
            for(List<String> account : accounts){
                String name = "";
                for(String email:account){
                    if(name == "" ){
                        name =email;
                        continue;
                    }

                    emailToName.put(email,name);
                    if(!emailToId.containsKey(email)){
                        emailToId.put(email,id++);
                    }

                    dsu.union(emailToId.get(account.get(1)),emailToId.get(email));
                }
            }
            Map<Integer,List<String>> ans = new HashMap<>();
            for(String email:emailToName.keySet()){
                int index = dsu.find(emailToId.get(email));
                ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
            }
            for(List<String> component: ans.values()){
                Collections.sort(component);
                component.add(0,emailToName.get(component.get(0)));
            }
            return  new ArrayList<>(ans.values());

    }


        public static void main(String[] args) {
        String[][] test1 = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
        List<List<String>> lists = createTest(test1);
        AccountMerge accountMerge = new AccountMerge();
        List<List<String>> ans = accountMerge.accountsMerge(lists);
        for(List<String> strs:ans){
            System.out.println(strs);
        }
        List<List<String>> ans1 = accountMerge.accountsMergeUnion(lists);
        for(List<String> strs:ans1){
            System.out.println(strs);
        }
    }
}
