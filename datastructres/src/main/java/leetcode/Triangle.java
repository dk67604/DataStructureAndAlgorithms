package main.java.leetcode;

import java.util.ArrayList;

public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
	
	public static void main(String[] args) {
		Triangle triangle=new Triangle();
		int [][] matrix=new int[][] {{2},{3,4},{6,5,7},{4,1,8,3}};
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		for(int i=0;i<matrix.length;i++) {
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0;j<matrix[i].length;j++) {
				temp.add(matrix[i][j]);
			}
			list.add(temp);
		}
		triangle.minimumTotal(list);
		
	}
}
