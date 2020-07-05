package main.java.systemdesign;

import java.util.*;
import java.util.stream.Collectors;

public class LogSystem {
        private TreeMap<String, List<Integer>> map;
        private Map<String,Integer> indexes;
        private String min = "2000:01:01:00:00:00",max="2017:12:31:23:59:59";
        public LogSystem(){
            map = new TreeMap<>();
            indexes = new HashMap<>();
            indexes.put("Year",4);
            indexes.put("Month",7);
            indexes.put("Day",10);
            indexes.put("Hour",13);
            indexes.put("Minute",16);
            indexes.put("Second",19);
        }
        public void put(int id,String timestamp){
            if(!map.containsKey(timestamp)){
                map.put(timestamp,new ArrayList<>());
            }
            map.get(timestamp).add(id);
        }

        public List<Integer> retrieve(String s, String e,String gra){
            List<Integer> result = new ArrayList<>();
            String start = s.substring(0,indexes.get(gra))+min.substring(indexes.get(gra));
            String end = e.substring(0,indexes.get(gra))+max.substring(indexes.get(gra));
            Map<String,List<Integer>> subMap = map.subMap(start,true,end,true);
            //Java 8 feature
            return subMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
        }
}
