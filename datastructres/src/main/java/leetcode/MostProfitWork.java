package main.java.leetcode;

import java.util.Arrays;

class Point {
    public int difficulty;
    public int profit;
	Point(int difficulty,int profit){
		this.difficulty=difficulty;
		this.profit=profit;
	}
	
}
public class MostProfitWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    	int len=difficulty.length;
    	Point[] jobs=new Point[len];
    	for(int i=0;i<len;i++) {
    		jobs[i]=new Point(difficulty[i], profit[i]);
    	}
    	Arrays.sort(jobs, (a,b)->a.difficulty-b.difficulty);
    	Arrays.sort(worker);
    	int ans=0,i=0,best=0;
    	for(int ability:worker) {
    		while(i<len&& ability>=jobs[i].difficulty) {
    			best=Math.max(best, jobs[i].profit);
    			i++;
    		}
    		ans+=best;
    	}
    	return ans;
    }
}
