package main.java.arraysstrings;

import java.util.HashSet;
import java.util.Set;

public class EvenSubsets {
    public static int countSubArray(int[] arr, int k) {
        if (arr != null && arr.length > 0) {
            int oddCount = 0, i = 0, last = -1;
            Set<String> subArray = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            while (i < arr.length) {
                int num = arr[i];
                if (num % 2 == 1) {
                    oddCount++;
                }
                subArray.add(String.valueOf(num));
                while (oddCount > k && last < i) {
                    int pop = arr[++last];
                    if (pop % 2 == 1) {
                        oddCount--;
                    }
                    if (last + 1 != i) {
                        sb.replace(0, sb.indexOf(",") + 1, "");
                        subArray.add(sb.toString());
                    } else {
                        sb = new StringBuilder();
                    }
                }

                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
                subArray.add(sb.toString());
                i++;
            }
            while (last < arr.length) {
                last++;
                sb.replace(0, sb.indexOf(",") + 1, "");
                subArray.add(sb.toString());
            }
            return subArray.size();
        }
        return 0;
    }

    public static int atMostK(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int n = a.length;
        int m = 1;

        // Function call
        System.out.println(atMostK(a, m));
    }
}
