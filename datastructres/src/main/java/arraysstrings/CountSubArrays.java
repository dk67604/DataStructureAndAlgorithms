package main.java.arraysstrings;
import java.util.*;
public class CountSubArrays {
    int[] countSubarrays(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] += ans[stack.pop()];
            }
            stack.push(i);
            ans[i]++;
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                ans[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubArrays countSubArrays = new CountSubArrays();
        int [] arr = {3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(countSubArrays.countSubarrays(arr)));

    }
}
