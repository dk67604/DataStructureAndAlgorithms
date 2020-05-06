package main.java.leetcode;

import java.util.*;
public class OptimalDistance {
	public static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		if (numDeliveries > numDestinations)
			return allLocations;
		TreeMap<Float, List<List<Integer>>> closestDestinations = new TreeMap<>();
		for (List<Integer> point : allLocations) {
			float dist = (float) Math.sqrt(point.get(0) * point.get(0) + point.get(1) * point.get(1));
			List<List<Integer>> temp = new ArrayList<>();
			if (closestDestinations.containsKey(dist))
				temp = closestDestinations.get(dist);
			temp.add(point);
			closestDestinations.put(dist, temp);
		}
		List<List<Integer>> result = new ArrayList<>();
		while (numDeliveries > 0) {
			List<List<Integer>> temp = closestDestinations.get(closestDestinations.firstKey());
			for (List<Integer> l : temp) {
				result.add(l);
				numDeliveries--;
			}
			closestDestinations.remove(closestDestinations.firstKey());
		}
		return result;
	}
	
	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, 
                                         List<List<Integer>> allLocations, 
                                         int numSteakhouses)
	{
        
        if (numSteakhouses > totalSteakhouses)
			return allLocations;
		TreeMap<Float, List<List<Integer>>> closestDestinations = new TreeMap<>();
		for (List<Integer> point : allLocations) {
			float dist = (float) Math.sqrt(point.get(0) * point.get(0) + point.get(1) * point.get(1));
			List<List<Integer>> temp = new ArrayList<>();
			if (closestDestinations.containsKey(dist))
				temp = closestDestinations.get(dist);
			temp.add(point);
			closestDestinations.put(dist, temp);
		}
		List<List<Integer>> result = new ArrayList<>();
		while (numSteakhouses > 0) {
			List<List<Integer>> temp = closestDestinations.get(closestDestinations.firstKey());
			for (List<Integer> l : temp) {
				result.add(l);
				numSteakhouses--;
			}
			closestDestinations.remove(closestDestinations.firstKey());
		}
		return result;
        
    }
    // METHOD SIGNATURE ENDS
	public static void main(String[] args) {
		int numDestinations=3;
		List<List<Integer>> allLocations=new ArrayList<>();
		List<Integer> temp=new ArrayList<>();
		temp.add(1);
		temp.add(2);	
		allLocations.add(temp);
		List<Integer> temp1=new ArrayList<>();
		temp1.add(3);
		temp1.add(4);
		allLocations.add(temp1);
		List<Integer> temp2=new ArrayList<>();
		temp2.add(1);
		temp2.add(-1);
		allLocations.add(temp2);
		int numDeliveries=2;
		List<List<Integer>> result = new ArrayList<>();

		result=ClosestXdestinations(numDestinations, allLocations, numDeliveries);
		for(List<Integer> item:result) {
			System.out.println(item);
		}
	}
	
}
