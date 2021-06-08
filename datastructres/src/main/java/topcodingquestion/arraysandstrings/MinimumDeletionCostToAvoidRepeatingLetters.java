package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
/*
Go through the string, accumulating cost in res and tracking max_cost. If the current character is different than previous one, we would subtract max_cost and set it to zero.

For a non-repeating characters, that means that the cost is zero (as we keep the most expensive single character).

For repeating characters, we would add cost to remove all of them except the most expensive one
 */
public class MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int res = cost[0], maxCost = cost[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res -= maxCost;
                maxCost = 0;
            }
            res += cost[i];
            maxCost = Math.max(maxCost, cost[i]);
        }
        return res - maxCost;
    }
}
