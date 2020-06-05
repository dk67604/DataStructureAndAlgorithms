package main.java.leetcode;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays=
                new CapacityToShipPackagesWithinDDays();
        capacityToShipPackagesWithinDDays.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5);
    }
}
