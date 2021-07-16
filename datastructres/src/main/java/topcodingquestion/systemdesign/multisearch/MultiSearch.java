package main.java.topcodingquestion.systemdesign.multisearch;

import main.java.topcodingquestion.utilities.HashMapList;

import java.util.ArrayList;

public class MultiSearch {
    private static Trie createTreeFromString(String[] small, int maxLen) {
        Trie tree = new Trie();
        for (String s : small) {
            if (s.length() <= maxLen) {
                tree.insertString(s, 0);
            }
        }
        return tree;
    }

    private static ArrayList<String> findStringAtLoc(TrieNode root, String big, int start) {
        ArrayList<String> strings = new ArrayList<String>();
        int index = start;
        while (index < big.length()) {
            root = root.getChild(big.charAt(index));
            if (root == null) break;
            if (root.terminates()) {//found the small word in big
                strings.add(big.substring(start, index + 1));
            }
            index++;
        }
        return strings;
    }

    private static void insertIntoHashMap(ArrayList<String> strings, HashMapList<String, Integer> map, int index) {
        for (String s : strings) {
            map.put(s, index);
        }
    }

    public static HashMapList<String, Integer> searchAll(String big, String[] small) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        TrieNode root = createTreeFromString(small, big.length()).getRoot();
        for (int i = 0; i < big.length(); i++) {
            ArrayList<String> strings = findStringAtLoc(root, big, i);
            insertIntoHashMap(strings, lookup, i);
        }
        return lookup;
    }

    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations.toString());
    }
}
