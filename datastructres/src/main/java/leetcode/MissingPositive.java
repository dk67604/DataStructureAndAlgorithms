package main.java.leetcode;

public class MissingPositive {

	public  int firstMissingPositive(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++) {
			while(nums[i]>0&&nums[i]<=n&&i+1!=nums[i]) {
				int curr=nums[i];
				swap(nums,i,curr-1); // Placing most positive at the beginning
				if (nums[i] == nums[curr - 1]) // Handle if all the element are same
		                break;
			}
		}
		for(int i=0;i<n;i++) {
			if(i+1!=nums[i]) return i+1;
		}
		return n+1;
	}
	
	public void swap(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	public int firstMissingPositive2(int[] nums) {
		int n = nums.length;
		// Base case
		int contains =0;
		for(int i =0;i<n;i++){
			if(nums[i]==1){
				contains++;
				break;
			}
		}
		if(contains  == 0){
			return 1;
		}
		if(n ==1){
			return 2;
		}

		// Replace negative number,zeros
		// and numbers which are gerater than n by 1s
		// After this conversion all the number in the array is positive
		for(int i =0; i<n; i++){
			if(nums[i] <= 0 || nums[i] >n )
				nums[i] =1;
		}
		//Use index as a hash key and number sign as a presence detector.
		// For example, if nums[1] is negative that means that number '1'
		// is present in the arrray.
		// if nums[2] is negative - number 2 is missing
		for(int i =0; i<n ;i++){
			int a = Math.abs(nums[i]);
			// If you meet number a in the array - change the sign of a-th element.
			// Be careful with duplicates : do it only once.
			if( a == n)
				nums[0] = - Math.abs(nums[0]);
			else
				nums[a] = - Math.abs(nums[a]);
		}
		//Now the index of the first positive number
		// is equal to the first missing positive
		for(int i =1; i<n ; i++){
			if(nums[i] > 0) return i;
		}
		if(nums[0] > 0) return n;

		return n+1;

	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1, 3, 6, 4, 1, 2};
		MissingPositive missingPositive=new MissingPositive();
		
		System.out.println(missingPositive.firstMissingPositive2(nums));
	}
}
