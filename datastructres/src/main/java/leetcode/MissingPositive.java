package main.java.leetcode;

public class MissingPositive {

	public  int firstMissingPositive(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++) {
			while(nums[i]>0&&nums[i]<=n&&i+1!=nums[i]) {
				int curr=nums[i];
				swap(nums,i,curr-1);
		         if (nums[i] == nums[curr - 1])
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
	
	public static void main(String[] args) {
		int[] nums=new int[] {1};
		MissingPositive missingPositive=new MissingPositive();
		
		System.out.println(missingPositive.firstMissingPositive(nums));
	}
}
