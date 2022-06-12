package main.java.topcodingquestion.stacks;

import java.util.Stack;

public class LargestAreaHistogram {
    public int largestAreaHistogram(int[] heights){
        int n = heights.length;
        int[] lb = new int[n]; // left boundary
        int[] rb = new int[n]; // right boundary
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        rb[n-1] = n;
        for(int i = n-2;i>=0;i--){
            while (st.size() > 0 && heights[i] < heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rb[i] = n;
            }else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for(int i = 1;i<n ;i++){
            while (st.size() > 0 && heights[i] < heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                lb[i] = -1;
            }else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for(int i =0; i< n;i++){
            int width = rb[i] - lb[i] -1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestAreaHistogram largestAreaHistogram = new LargestAreaHistogram();
        System.out.println(largestAreaHistogram.largestAreaHistogram(new int[]{2,1,5,6,2,3}));
    }
}
