package main.java.leetcode;

import java.util.Arrays;

//Edge case
/*
1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
3. For other cases, we need to process the number from rightmost side (why? because we need to find the smallest of all greater numbers)
 Now the main algorithm works in following steps -

I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.

II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

III) Swap the above found two digits, we get 536974 in above example.

IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.

 */
public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII nextGreaterElementIII = new NextGreaterElementIII();
        int n = 12;
        System.out.println(nextGreaterElementIII.nextGreaterElement(n));
        System.out.println(nextGreaterElementIII.nextGreaterElement(121));
    }

    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i, j;
        // I) Start from the right most digit and
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = a.length - 1; i > 0; i--) {
            if (a[i - 1] < a[i])
                break;
        }
        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;
        // II) Find the smallest digit on right side of (i-1)'th
        // digit that is greater than number[i-1]
        int x = a[i - 1];
        int smallest = i;
        for (j = i + 1; j < a.length; j++) {
            if (a[j] > x && a[j] <= a[smallest]) {
                smallest = j;
            }
        }
        // III) Swap the above found smallest digit with
        // number[i-1]
        char temp = a[i - 1];
        a[i - 1] = a[smallest];
        a[smallest] = temp;
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(a, i, a.length);
        long val = Long.parseLong(new String(a));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
