package main.java.dsa_2024.algorithms;

class Time{
    String key;
    String value;
    int timestamp;
    Time prev;

    public Time(String key, String value, int timestamp){
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
        this.prev = null;
    }
}
public class TimeBasedKeyValueStore {
    Time timeMap;

    public TimeBasedKeyValueStore(){
        timeMap = null;
    }

    public void set(String key, String value, int timestamp){
        Time temp = new Time(key, key, timestamp);
        temp.prev = timeMap;
        timeMap = temp;
    }
    public String get(String key, int timestamp) {
        return get(key, timestamp, timeMap);
    }

    public String get(String key, int timestamp, Time map){
        if(map == null){
            return "";
        }
        if (key.equals(map.key)){
            if (map.timestamp <= timestamp){
                return map.value;
            }
        }
        return get(key, timestamp, map.prev);
    }
}
