package main.java.topcodingquestion.arraysandstrings;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> lookup = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!lookup.containsKey(key)) lookup.put(key, new ArrayList<String>());
            lookup.get(key).add(str);
        }
        list.addAll(lookup.values());
        return list;

    }
}
