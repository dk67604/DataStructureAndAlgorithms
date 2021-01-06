package main.java.leetcode;

/*
Explanation: we need to cut (a) longest length wood as possible but also satisfy condition (b) where number of longest wood cuts >= k.
First we need to find the longest wood in the array:
right = max(woods)
Using that longest wood as our cut range, we can do binary search where the middle will be a cut length and
divide every wood by middle to check if we can cut every wood with that length.
But what is our left for our binary search. Is it 0? No, it should be one.
Remember left and right in our binary search is possible cut length not index.
The lowest cut can be 1 not 0. We can't cut wood by 0 length. That's why:

left = 1
right = max(woods)

while left < right:
      middle = (left + right) // 2
Now, we will use the middle number as a possible cut length and check
if every wood in woods can be cut with that length.
We need a helper function for it that loop and checks and returns true if number of woodCuts is <= k:

If helper returns True, we update our result variable. And since we want even longer wood cuts,
we move our left pointer in binary to middle+1.
Otherwise, we move our right to middle if wood cut was not valid.
 */
public class CutWood {
    public boolean isValid(int[] wood, int cutLength, int k){
        int count = 0;
        for(int w: wood){
            count += w / cutLength;
        }
        return count >= k;
    }
    private  int getMax(int[] woods){
        int max = Integer.MIN_VALUE;
        for(int w:woods){
            max = Math.max(max,w);
        }
        return max;
    }
    public int cutWood(int[] wood, int k){
        // corner cases:
        if(wood.length == 0 || k == 0) return 0;
        int left = 1, right = getMax(wood);
        int res = 0;
        if(!isValid(wood, left, k)) return 0;
        while(left < right){
            int mid = left + (right - left)/2;
            boolean valid = isValid(wood, mid, k);
            if(valid){
                left = mid + 1;
                res = mid;
            }
            else
                right = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        CutWood cutWood = new CutWood();
        int[][]testcases_wood = { {5, 9, 7} ,{5, 9, 7} };
        int[] testcases_k = {3, 4};
        for(int i = 0; i < testcases_wood.length; ++i)
            System.out.println(cutWood.cutWood(testcases_wood[i], testcases_k[i]));
    }
    }

