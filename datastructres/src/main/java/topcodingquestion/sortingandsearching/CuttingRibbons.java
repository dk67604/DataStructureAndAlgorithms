package main.java.topcodingquestion.sortingandsearching;

/**
 * You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k. You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.
 *
 * For example, if you have a ribbon of length 4, you can:
 * Keep the ribbon of length 4,
 * Cut it into one ribbon of length 3 and one ribbon of length 1,
 * Cut it into two ribbons of length 2,
 * Cut it into one ribbon of length 2 and two ribbons of length 1, or
 * Cut it into four ribbons of length 1.
 * Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.
 *
 * Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.
 */
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k){
        int sum =0, r=0,l=1,ans =0;
        for(int ribbon: ribbons){
            r = Math.max(ribbon,r);
        }
        while (l <= r){
            int mid = l + (r - l)/2;//Our current length in the search space
            sum = 0;
            for (int ribbon : ribbons){//The number of segments obtained with mid-length
                sum += ribbon/mid;
            }
            if(sum >= k){ //Maybe there's a better answer, move to the right
                ans = mid;
                l = mid +1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CuttingRibbons cuttingRibbons = new CuttingRibbons();
        System.out.println(cuttingRibbons.maxLength(new int[]{9,7,5},3));
    }
}
