package main.java.leetcode;
import java.util.ArrayList; 
import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}

//We will have n nodes and an edge directed from node i to node j if the element at
//i’th index must be present at j’th index in the sorted array
public class MinimumSwaps {
 public int minimumSwaps(int[] nums) {
	 int n=nums.length;
	 List<Pair> posList=new ArrayList<>();
	 for(int i=0;i<nums.length;i++)
		 posList.add(new Pair(nums[i],i));
	 
	 posList.sort(new Comparator<Pair>() {

		@Override
		public int compare(Pair o1, Pair o2) {
			if(o1.x>o2.x)
				return 1;
			else if(o1.x==o2.x)
				return 0;
			else
				return -1;
		}
	});
	  // To keep track of visited elements. Initialize 
     // all elements as not visited or false. 
     Boolean[] vis = new Boolean[n]; 
     Arrays.fill(vis, false); 

     // Initialize result 
     int ans = 0; 

     // Traverse array elements 
     for (int i = 0; i < n; i++) 
     { 
         // already swapped and corrected or 
         // already present at correct pos 
         if (vis[i] || posList.get(i).y == i) 
             continue; 

         // find out the number of  node in 
         // this cycle and add in ans 
         int cycle_size = 0; 
         int j = i; 
         while (!vis[j]) 
         { 
             vis[j] = true; 

             // move to next node 
             j = posList.get(j).y; 
             cycle_size++; 
         } 

         // Update answer by adding current cycle. 
         if(cycle_size > 0) 
         { 
             ans += (cycle_size - 1); 
         } 
     } 

     // Return result 
     return ans;
 }
 
 public static void main(String[] args) {
	 int nums[] = {4, 3, 2, 1}; 
		int n = nums.length; 
		MinimumSwaps minimumSwaps=new MinimumSwaps();
		int ans=minimumSwaps.minimumSwaps(nums);
		System.out.println(ans);
}
}
