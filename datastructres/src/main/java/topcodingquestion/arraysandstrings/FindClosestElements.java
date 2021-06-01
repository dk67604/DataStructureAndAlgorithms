package main.java.topcodingquestion.arraysandstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        //Perform binary search to find closest mid position
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == x) {
                break;
            }
            if (x > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int l = mid - 1;
        int r = mid;
        List<Integer> result = new ArrayList<>();
        while (l >= 0 && r < arr.length && k > 0) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                result.add(arr[l]);
                l--;
            } else {
                result.add(arr[r]);
                r++;
            }
            k--;
        }

        while (k > 0 && l >= 0) {
            result.add(arr[l]);
            l--;
            k--;
        }
        while (k > 0 && r < arr.length) {
            result.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(result);
        return result;

    }
}
