package main.java.dsa_2024.systemdesign;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CountMinSketch {
    private final int width;
    private final int depth;
    private final int[][] table;
    private final int[] hashSeeds;

    public CountMinSketch(int width, int depth) {
        this.width = width;
        this.depth = depth;
        this.table = new int[depth][width];
        this.hashSeeds = new int[depth];

        for (int i = 0; i < depth; i++) {
            hashSeeds[i] = i + 1;  // simple seed generation, could be more sophisticated
        }
    }

    private int hash(String item, int seed) throws NoSuchAlgorithmException {
        String input = seed + item;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger bigInt = new BigInteger(1, digest);
        return bigInt.mod(BigInteger.valueOf(width)).intValue();
    }

    public void add(String item) {
        try {
            for (int i = 0; i < depth; i++) {
                int index = hash(item, hashSeeds[i]);
                table[i][index]++;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public int estimate(String item) {
        int minCount = Integer.MAX_VALUE;
        try {
            for (int i = 0; i < depth; i++) {
                int index = hash(item, hashSeeds[i]);
                minCount = Math.min(minCount, table[i][index]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return minCount;
    }

    public static void main(String[] args) {
        CountMinSketch cms = new CountMinSketch(100, 5);

        // Add items
        cms.add("apple");
        cms.add("banana");
        cms.add("apple");

        // Estimate frequency
        System.out.println("Estimated frequency of 'apple': " + cms.estimate("apple"));
        System.out.println("Estimated frequency of 'banana': " + cms.estimate("banana"));
        System.out.println("Estimated frequency of 'orange': " + cms.estimate("orange"));
    }
}
