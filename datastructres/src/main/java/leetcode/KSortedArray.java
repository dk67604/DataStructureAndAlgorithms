package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {

	public List<Integer> sortKSortedArray(List<Integer> nums,int k){
		PriorityQueue<Integer> pq=new PriorityQueue<>(nums.subList(0, k+1));
		int index=0;
		for(int i=k+1;i<nums.size();i++) {
			nums.set(index++, pq.poll());
			pq.add(nums.get(i));
		}
		while(!pq.isEmpty()) {
			nums.set(index++, pq.poll());
		}
		return nums;
	}
	
	public static void main(String[] args) {
		KSortedArray kSortedArray=new KSortedArray();
		List<Integer> nums=new ArrayList<>(Arrays.asList(1,4,5,2,3,7,8,6,10,9));
		nums=kSortedArray.sortKSortedArray(nums, 2);
		System.out.println(nums);
	}
}
