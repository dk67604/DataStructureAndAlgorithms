package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomDelete {
  List<Integer> nums;
  Map<Integer, Integer> map;
  Random  rand=new Random();
  public RandomDelete() {
	// TODO Auto-generated constructor stub
	  nums=new ArrayList<>();
	  map=new HashMap<>();
}
  
  
  
  public boolean insert(int val) {
	  boolean contain=map.containsKey(val);
	  if(contain)return false;
	  map.put(val, nums.size());
	  nums.add(val);
	  return true;
  }
  
  public boolean remove(int val) {
	  boolean contain=map.containsKey(val);
	  if(!contain) return false;
	  int loc=map.get(val);
	  if(loc<nums.size()-1) {
		  int last=nums.get(nums.size()-1);
		  nums.set(loc, last);
		  map.put(last, loc);
	  }
	  map.remove(val);
	  nums.remove(nums.size()-1);
	  return true;
  }
  
  public int getRandom() {
	  return nums.get(rand.nextInt(nums.size()));
  }
}
