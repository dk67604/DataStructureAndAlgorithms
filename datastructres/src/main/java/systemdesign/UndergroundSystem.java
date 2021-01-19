package main.java.systemdesign;

import java.util.HashMap;
import java.util.Map;

class Passenger{
    int checkInTime;
    int checkOutTime;
    String checkInStation;
    String checkOutStation;

    public Passenger(String checkInStation, int checkInTime){
        this.checkInStation = checkInStation;
        this.checkInTime = checkInTime;
    }
    public void checkout(String checkOutStation,int checkOutTime){
        this.checkOutStation = checkOutStation;
        this.checkOutTime = checkOutTime;
    }
}

class Route{
    String route;
    long totalTripTime;
    int totalNumOfTrips;

    public Route(String checkInLocation, String checkOutLocation){
        this.route = checkInLocation + "," + checkOutLocation;
    }
    double getAverageTime(){
        return (double) totalTripTime / totalNumOfTrips;
    }

    void addTrips(int startTime,int endTime){
        totalTripTime += endTime - startTime;
        totalNumOfTrips ++;
    }

}

public class UndergroundSystem {
    Map<Integer, Passenger> currentPassengerMap;
    Map<String,Route> routeMap;

    public UndergroundSystem(){
        this.currentPassengerMap = new HashMap<>();
        this.routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName,int t){
        if(!currentPassengerMap.containsKey(id)){
            Passenger passenger = new Passenger(stationName,t);
            currentPassengerMap.put(id,passenger);
        }
    }

    public void checkOut(int id, String stationName,int t){
        if(currentPassengerMap.containsKey(id)){
            Passenger passenger = currentPassengerMap.get(id);
            passenger.checkout(stationName,t);
            String routeKey = passenger.checkInStation + "," + passenger.checkOutStation;
            Route route = routeMap.getOrDefault(routeKey, new Route(passenger.checkInStation, passenger.checkOutStation));
            route.addTrips(passenger.checkInTime,passenger.checkOutTime);
            routeMap.put(routeKey,route);
            currentPassengerMap.remove(id);

        }
    }
    public double getAverageTime(String startStation, String endStation){
        return routeMap.get(startStation +","+endStation).getAverageTime();
    }
}
