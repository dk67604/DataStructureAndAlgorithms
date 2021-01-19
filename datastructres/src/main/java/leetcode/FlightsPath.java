package main.java.leetcode;

import java.util.*;


public class FlightsPath {

    public List<String> findFlightPath(List<List<String>> flights){
        List<String> flightPath = new ArrayList<>();
        if(flights.size() == 0) return flightPath;
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Integer> inDegree = new HashMap<>();
        for(List<String> flight : flights){
            for(int i =0; i < flight.size();i++){
                graph.putIfAbsent(flight.get(i),new ArrayList<>());
                inDegree.putIfAbsent(flight.get(i),0);
            }
        }
        for(List<String> flight : flights){
            String src = flight.get(0), dest = flight.get(1);
            graph.get(src).add(dest);
            inDegree.put(dest,inDegree.get(dest) +1);
        }
        Queue<String> sources = new LinkedList<>();
        for(Map.Entry<String,Integer> entry : inDegree.entrySet()){
            if(entry.getValue() ==0){
                sources.offer(entry.getKey());
            }
        }
        while (!sources.isEmpty()){
            String vertex = sources.poll();
            flightPath.add(vertex);
            List<String> children = graph.get(vertex);
            for(String child : children){
                inDegree.put(child,inDegree.get(child) -1);
                if(inDegree.get(child) == 0)
                    sources.offer(child);
            }

        }

        return flightPath;
    }
    private static List<List<String>> createTestInput(String[][] flightsArr){
        List<List<String>> flights = new ArrayList<>();
        for(int i = 0 ; i< flightsArr.length;i++) {
            List<String> flight = new ArrayList<>();
            flight.add(flightsArr[i][0]);
            flight.add(flightsArr[i][1]);
            flights.add(flight);
        }
        return flights;
    }

    public static void main(String[] args) {

        String[][] flightsArr = {{"ORD","DNV"},{"SFO","NYC"},{"LAX","SFO"},{"NYC","ORD"}};
        List<List<String>> flights = createTestInput(flightsArr);
        FlightsPath flightsPath = new FlightsPath();
        System.out.println(flightsPath.findFlightPath(flights));
        flightsArr = new String[][]{{"DFW", "CLT"}, {"SFO", "DFW"}, {"WAS", "NYK"}, {"LAX", "SFO"},{"CLT","WAS"}};
        flights = createTestInput(flightsArr);
        System.out.println(flightsPath.findFlightPath(flights));
        }

    }

