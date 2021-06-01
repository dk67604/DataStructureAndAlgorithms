package main.java.topcodingquestion.arraysandstrings;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    area += maxLeft - height[left];
                }
                left += 1;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    area += maxRight - height[right];
                }
                right -= 1;
            }
        }
        return area;

    }
}
