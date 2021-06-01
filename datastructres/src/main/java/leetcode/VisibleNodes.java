package main.java.leetcode;

public class VisibleNodes {
    static int count;

    public static void main(String[] args) {
        VisibleNodes visibleNodes = new VisibleNodes();
        Tree T = new Tree(8);
        T.l = new Tree(2);
        T.r = new Tree(6);
        T.l.l = new Tree(8);
        T.l.r = new Tree(7);
        System.out.println(visibleNodes.solution(T));
    }

    public int solution(Tree T) {
        if (T == null) {
            return 0;
        }
        int[] count = new int[1];
        return helper(T, Integer.MIN_VALUE, count);

    }

    private void helper(Tree tree, int max) {
        if (tree == null) {
            return;
        }
        if (tree.x >= max) {
            count++;
            max = Math.max(tree.x, max);
        }
        helper(tree.l, max);
        helper(tree.r, max);

    }

    private int helper(Tree tree, int max, int[] count) {
        if (tree == null) {
            return 0;
        }
        count[0] = tree.x >= max ? 1 : 0;
        count[0] += helper(tree.l, Math.max(max, tree.x), count);
        count[0] += helper(tree.r, Math.max(max, tree.x), count);

        return count[0];

    }

    static class Tree {
        int x;
        Tree l;
        Tree r;

        public Tree(int x) {
            this.x = x;
        }
    }
}
