package main.java.leetcode;

public class KEmptySlots {
    public static void main(String[] args) {
        int[] flowers = new int[]{1, 3, 2};
        int k = 1;
        KEmptySlots kEmptySlots = new KEmptySlots();
        System.out.println(kEmptySlots.kEmptySlots(flowers, k));
    }

    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < days.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0, right = k + 1;

        for (int i = 1; right < days.length; i++) {
            if (days[i] > days[left] && days[i] > days[right])
                continue;
            if (i == right)
                ans = Math.min(ans, Math.max(days[left], days[right]));
            left = i;
            right = left + k + 1;

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
