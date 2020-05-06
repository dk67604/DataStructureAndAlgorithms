package main.java.leetcode;
import java.util.*;
public class SubArrayWithSumK {

//	public List<Integer> findAllSubArraySum(int[] nums,int k){
//		List<>
//	}
	public static void main(String[] args) {
	    int[] INPUT = {5, 6, 1, -2, -4, 3, 1, 5};
	    List<Integer[]> result=printSubarrays(INPUT, 5);
	    for(Integer[] i:result) {
	    	System.out.println(i[0]+","+i[1]);
	    }
	}

	private static List<Integer[]> printSubarrays(int[] input, int k) {
	    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	    List<Integer> initial = new ArrayList<Integer>();
	    List<Integer[]> result=new ArrayList<>(); 
	    initial.add(-1);
	    map.put(0, initial);
	    int preSum = 0;

	    // Loop across all elements of the array
	    for(int i=0; i< input.length; i++) {
	        preSum += input[i];
	        // If point where sum = (preSum - k) is present, it means that between that 
	        // point and this, the sum has to equal k
	        if(map.containsKey(preSum - k)) {   // Subarray found 
	            List<Integer> startIndices = map.get(preSum - k);
	            for(int start : startIndices) {
//	                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
	            	result.add(new Integer[] {start+1,i});
	            }
	        }

	        List<Integer> newStart = new ArrayList<Integer>();
	        if(map.containsKey(preSum)) { 
	            newStart = map.get(preSum);
	        }
	        newStart.add(i);
	        map.put(preSum, newStart);
	    }
	    return result;
	}
}
