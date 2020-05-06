package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RangeMinimumQuery {

	int[] segtree;

	

    int construct(int arr[], int ss, int se, int si) 
    {  
        if (ss == se) { 
        	segtree[si] = arr[ss]; 
            return arr[ss]; 
        } 
  
        int mid = getMid(ss, se); 
        segtree[si] = minVal(construct(arr, ss, mid, si * 2 + 1), 
        		construct(arr, mid + 1, se, si * 2 + 2)); 
        return segtree[si]; 
    } 
    
 void construct(int arr[], int n) 
 { 
   
     int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 

   
     int maxSize = 2 * (int) Math.pow(2, x) - 1; 
     segtree = new int[maxSize]; 

    
     construct(arr, 0, n - 1, 0); 
 } 
	
    public int minVal(int x, int y) { 
        return (x < y) ? x : y; 
    }
    
   
    public int getMid(int start, int end) { 
        return start + (end - start) / 2; 
    } 
   
    int rangeMinimumQuery(int n, int queryStart, int queryEnd) 
    { 
        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) { 
            
            return -1; 
        } 
  
        return helper(0, n - 1, queryStart, queryEnd, 0); 
    } 
  
   public int helper(int start, int end, int queryStart, int queryEnd, int index) 
    { 
    
        if (queryStart <= start && queryEnd >= end) 
            return segtree[index]; 
  
 
        if (end < queryStart || start > queryEnd) 
            return Integer.MAX_VALUE; 
  
        int mid = getMid(start, end); 
        return minVal(helper(start, mid, queryStart, queryEnd, 2 * index + 1), 
                helper(mid + 1, end, queryStart, queryEnd, 2 * index + 2)); 
    } 
   
   public static void main(String[] args) {
   
       Scanner sc = new Scanner(System.in);
   	   int a = sc.nextInt();
	   int b = sc.nextInt();
	   int[] nums=new int[a];
	   List<List<Integer>> list=new ArrayList<>();
	   for(int i=0;i<nums.length;i++) {
		   nums[i]=sc.nextInt();
	   }
	   int n=nums.length;
	   for(int i=0;i<b;i++) {
		   List<Integer> temp=new ArrayList<>();
		   temp.add(sc.nextInt());
		   temp.add(sc.nextInt());
		   list.add(temp);
	   }
	  
       RangeMinimumQuery rangeMinimumQuery=new RangeMinimumQuery();
       rangeMinimumQuery.construct(nums, n);
       for(List<Integer> temp:list) {
    	   int result=rangeMinimumQuery.rangeMinimumQuery(n, temp.get(0), temp.get(1));
    	   System.out.println(result);
       }
      
}
}
