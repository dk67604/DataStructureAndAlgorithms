package main.java.dsa_2024.algorithms;

import java.util.*;
public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer tmKey = treeMap.floorKey(timestamp);
        if(tmKey == null){
            return "";
        }
        else{
            return treeMap.get(tmKey);
        }
    }

}
