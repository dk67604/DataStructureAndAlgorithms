package main.java.topcodingquestion.treesandgraphs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.

 Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved.

 Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.



 Example 1:



 Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 Output: 4
 Explanation: The figure above shows the optimal allocation for four groups, where seats mark with blue are already reserved and contiguous seats mark with orange are for one group.
 Example 2:

 Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 Output: 2
 Example 3:

 Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 Output: 4
 From the code, max means the maximum allocations we can do for the rows with reserved seats. After that, we also need to count the rows won't have any reserved seats. The graph.size() contains all rows which have seats reserved. n - graph.size() contains all rows don't have any seats reserved, and we can allocate 2 families with a group of 4 people each, so 2 * (n - graph.size()) is the total number of allocations we can do for rows don't have any seats reserved.

 Finally, we have maximum number of allocations:
 Maximum Allocations = Total number allocations for rows with reserved seats + Total number allocations for rows don't have any reserved seats
 = max + 2 * (n - graph.size()).
 */
public class CinemaSeatAllocations {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //Create Bit Vector for each row
        Map<Integer,Integer> bitVectorLookup = new HashMap<>();
        for(int[] reserved : reservedSeats){
            int row = reserved[0];
            int col = reserved[1];
            bitVectorLookup.put(row, bitVectorLookup.getOrDefault(row,0) | (1 << col));
        }
        int max = 0;
        for (int row : bitVectorLookup.keySet()){
            int cnt = 0;
            int reserved = bitVectorLookup.get(row);
            if((reserved & 60) == 0) cnt+=1; // check if seats 2,3,4,5 are available
            if((reserved & 960) == 0) cnt +=1; // check if seats 6,7,8,9 are available
            if((reserved & 240) ==0 && cnt == 0) cnt =1;// check if seats 4,5,6,7 are available
            max += cnt;
        }
        return max + 2 * (n - bitVectorLookup.size());
        
    }
}
