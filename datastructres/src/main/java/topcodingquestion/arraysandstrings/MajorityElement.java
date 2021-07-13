package main.java.topcodingquestion.arraysandstrings;

public class MajorityElement {
    public static int findMajorityElement(int[] array) {
        int candidate = getCandidate(array);
        return validate(array, candidate) ? candidate : -1;
    }

    private static int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;
        for (int n : array) {
            if (count == 0) {// No majority element in previous set
                majority = n;
            }
            if (n == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    private static boolean validate(int[] array, int majority) {
        int count = 0;
        for (int n : array) {
            if (n == majority) {
                count++;
            }
        }
        return count > array.length / 2;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 1, 1, 7, 7, 3, 7, 7, 7};
        System.out.println(findMajorityElement(nums));
    }
}
