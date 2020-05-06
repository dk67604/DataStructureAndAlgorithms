package main.java.leetcode;
import java.util.*;
public class OptimizeRoute {
	
	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(
	                        int deviceCapacity, 
                            List<List<Integer>> foregroundAppList,
                            List<List<Integer>> backgroundAppList)
	{
    	 List<List<Integer>> result = new ArrayList<>();
	       List<Integer[]> store = new ArrayList<>();
	       Collections.sort(foregroundAppList, new Comparator<List<Integer>>()
		      {
		         @Override
		         public int compare(final List<Integer> f, final List<Integer> s)
		         {

		            return Integer.compare(f.get(1), s.get(1));
		         }
		      });
	       
	       int currentMax=Integer.MIN_VALUE;
	      
	       for(List<Integer> b:backgroundAppList) {
	    	   Integer[] temp=new Integer[3];
		       Arrays.fill(temp, 0);
	    	   int begin=0;
		       int end=foregroundAppList.size();
		       int difference=deviceCapacity-b.get(1);
		       while(begin<end) {
		    	   int mid=(begin+end)/2;
		    	   if(foregroundAppList.get(mid).get(1)<=difference)
		    		   begin=mid+1;
		    	   else
		    		   end=mid;
		       }
		       if(begin!=0 && (b.get(1)+foregroundAppList.get(begin-1).get(1))>=temp[0]) {
		    	   temp[0]=b.get(1)+foregroundAppList.get(begin-1).get(1);
		    	   temp[1]=foregroundAppList.get(begin-1).get(0);
		    	   temp[2]=b.get(0);
		    	   currentMax=Math.max(currentMax, temp[0]);
		    	   store.add(temp);
		       }
	       }
	       for(Integer[] item:store) {
	    	   List<Integer> optimal=new ArrayList<>();
	    	   if(currentMax==deviceCapacity && item[0]==currentMax) {   		   
	    		   optimal.add(item[1]);
	    		   optimal.add(item[2]);
	    		   result.add(optimal);
	    	   }
	    	   else if(item[0]==currentMax) {
	    		   optimal.add(item[1]);
	    		   optimal.add(item[2]);
	    		   result.add(optimal);
	    	   }
	       }
	       return result;
    }
    
    public static List<List<Integer>> code4a(int max, List<List<Integer>> fwd, List<List<Integer>> bck) {
        List<List<Integer>> ans = new ArrayList<>();
        int diff = 0;

        for (List<Integer> f : fwd) {
            for (List<Integer> b : bck) {
                int total = f.get(1) + b.get(1);
                int d = max - total;
                if (d == diff)
                    ans.add(new ArrayList<>(Arrays.asList(f.get(0), b.get(0))));
                else if (d >= 0 && diff > d) {
                    ans.clear();
                    ans.add(new ArrayList<>(Arrays.asList(f.get(0), b.get(0))));
                }
            }
        }

        return ans;
    }
	
	public static List<List<Integer>> calculateOptimalRoute(int capacity,List<List<Integer>> forward,List<List<Integer>> backward){
	       List<List<Integer>> result = new ArrayList<>();
	       List<Integer[]> store = new ArrayList<>();
	       Collections.sort(forward, new Comparator<List<Integer>>()
		      {
		         @Override
		         public int compare(final List<Integer> f, final List<Integer> s)
		         {

		            return Integer.compare(f.get(1), s.get(1));
		         }
		      });
	       
	       int currentMax=Integer.MIN_VALUE;
	      
	       for(List<Integer> b:backward) {
	    	   Integer[] temp=new Integer[3];
		       Arrays.fill(temp, 0);
	    	   int begin=0;
		       int end=forward.size();
		       int difference=capacity-b.get(1);
		       while(begin<end) {
		    	   int mid=(begin+end)/2;
		    	   if(forward.get(mid).get(1)<=difference)
		    		   begin=mid+1;
		    	   else
		    		   end=mid;
		       }
		       if(begin!=0 && (b.get(1)+forward.get(begin-1).get(1))>=temp[0]) {
		    	   temp[0]=b.get(1)+forward.get(begin-1).get(1);
		    	   temp[1]=forward.get(begin-1).get(0);
		    	   temp[2]=b.get(0);
		    	   currentMax=Math.max(currentMax, temp[0]);
		    	   store.add(temp);
		       }
	       }
	       for(Integer[] item:store) {
	    	   List<Integer> optimal=new ArrayList<>();
	    	   if(currentMax==capacity && item[0]==currentMax) {   		   
	    		   optimal.add(item[1]);
	    		   optimal.add(item[2]);
	    		   result.add(optimal);
	    	   }
	    	   else if(item[0]==currentMax) {
	    		   optimal.add(item[1]);
	    		   optimal.add(item[2]);
	    		   result.add(optimal);
	    	   }
	       }
	       return result;
	}
	
	
	public List<List<Integer>> findOptimalMemory(final int capacity, final List<List<Integer>> foreground,
	         final List<List<Integer>> background)
	   {
	      int i = 0;
	      int j = background.size() - 1;
	      final List<List<Integer>> result = new ArrayList<>();
	      final List<List<Integer>>[] store = new ArrayList[capacity + 1];
	      Collections.sort(foreground, new Comparator<List<Integer>>()
	      {
	         @Override
	         public int compare(final List<Integer> f, final List<Integer> s)
	         {

	            return Integer.compare(f.get(1), s.get(1));
	         }
	      });

	      Collections.sort(background, new Comparator<List<Integer>>()
	      {
	         @Override
	         public int compare(final List<Integer> f, final List<Integer> s)
	         {

	            return Integer.compare(f.get(1), s.get(1));
	         }
	      });

	      while (i < foreground.size() && j > -1)
	      {
	         final int current = foreground.get(i).get(1) + background.get(j).get(1);
	         if (current <= capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<>();
	            store[current].add(Arrays.asList(new Integer[] { foreground.get(i).get(0), background.get(j).get(0) }));
	         }

	         if (current <= capacity)
	         {
	            ++i;
	         }
	         else if (current > capacity)
	         {
	            --j;
	         }
	      }

	      while (i < foreground.size())
	      {
	         final int current = foreground.get(i).get(1) + background.get(0).get(1);
	         if (current < capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<>();
	            store[current].add(Arrays.asList(new Integer[] { foreground.get(i).get(0), background.get(0).get(0) }));
	         }
	         ++i;
	      }

	      while (j > -1)
	      {

	         final int current = foreground.get(foreground.size() - 1).get(1) + background.get(j).get(1);
	         if (current < capacity)
	         {
	            if (store[current] == null)
	               store[current] = new ArrayList<>();
	            store[current]
	                  .add(Arrays.asList(new Integer[] { foreground.get(foreground.size() - 1).get(0), background.get(j).get(0) }));
	         }

	         --j;
	      }

	      for (int k = capacity; k > -1; --k)
	      {
	         if (store[k] != null)
	         {
	            result.addAll(store[k]);
	            break;
	         }
	      }
	      return result;
	   }
	public static void main(String[] args) {
		
		List<List<Integer>> backward=new ArrayList<>();
		List<List<Integer>> forward=new ArrayList<>();
		List<Integer> temp=new ArrayList<>();
		temp.add(1);
		temp.add(3000);	
		forward.add(temp);
		List<Integer> temp1=new ArrayList<>();
		temp1.add(2);
		temp1.add(5000);
		forward.add(temp1);
		List<Integer> temp3=new ArrayList<>();
		temp3.add(3);
		temp3.add(4000);
		forward.add(temp3);
		List<Integer> temp4=new ArrayList<>();
		temp4.add(4);
		temp4.add(10000);
		forward.add(temp4);
		List<Integer> temp5=new ArrayList<>();
		temp5.add(1);
		temp5.add(2000);
		backward.add(temp5);
		List<Integer> temp6=new ArrayList<>();
		temp6.add(2);
		temp6.add(3000);
		backward.add(temp6);
		List<Integer> temp7=new ArrayList<>();
		temp7.add(3);
		temp7.add(4000);
		backward.add(temp7);
//		List<Integer> temp8=new ArrayList<>();
//		temp8.add(4);
//		temp8.add(5000);
//		backward.add(temp8);
		
		
		
		List<List<Integer>> result = new ArrayList<>();
		result=code4a(11000, forward, backward);
		for(List<Integer> item:result) {
			System.out.println(item);
		}
		
		

	}
}
