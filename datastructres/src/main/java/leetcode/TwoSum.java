package main.java.leetcode;

import java.util.Arrays;

public class TwoSum {
	
	public boolean hasArrayTwoCandidate(int A[],int target) {
		int length=A.length;
		Arrays.sort(A);
		int l=0;int r=length-1;
		while(l<r) {
			if(A[l]+A[r]==target)
				return true;
			else if(A[l]+A[r]<target)
				l++;
			else
				r--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		System.out.println(twoSum.hasArrayTwoCandidate(new int[] {1, 4, 45, 6, 10, -8}, 52));
	}

}
