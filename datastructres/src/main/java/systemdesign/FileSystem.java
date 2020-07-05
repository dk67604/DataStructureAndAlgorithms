package main.java.systemdesign;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    Map<String,Integer> map;

    public FileSystem(){
        map = new HashMap<>();
        map.put("",-1);
    }

    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf('/');
        String parent = path.substring(0,idx);
        if(!map.containsKey(parent))return false; //if parent doesn't exists return false;
        return map.putIfAbsent(path,value) == null; // return true if path  added to file system
    }

    public int get(String path) {
        return map.getOrDefault(path,-1);
    }
}
