package main.java.arraysstrings;

public class CountTeams {
    static int binomialCoeff(int n, int k) {
        int[] C = new int[k + 1];

        // nC0 is 1
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }


    public static int countTeams(int[] nums, int minPlayer, int min, int max) {
        int numberOfPlayers = 0;
        for (int num : nums) {
            if (num >= min && num <= max) {
                numberOfPlayers++;
            }
        }
        int countTeam = 0;
        for (int i = minPlayer; i <= numberOfPlayers; i++) {
            countTeam += binomialCoeff(numberOfPlayers, i);
        }
        return countTeam;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 4, 6, 13, 5, 10};
        int minPlayer = 3;
        int minLevel = 4;
        int maxLevel = 10;
        System.out.println(countTeams(nums, minPlayer, minLevel, maxLevel));
        nums = new int[]{12, 4, 6, 13, 5, 10};
        minPlayer = 2;
        minLevel = 4;
        maxLevel = 6;
        System.out.println(countTeams(nums, minPlayer, minLevel, maxLevel));

    }
}
