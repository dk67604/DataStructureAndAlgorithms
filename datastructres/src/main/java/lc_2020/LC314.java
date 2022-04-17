package main.java.lc_2020;

import java.util.*;

/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 *
 *
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 *
 *
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class LC314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();//level order traversal
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> columnList = new LinkedList<>();
        queue.add(root);
        columnList.add(0);
        int minCol = 0;
        int maxCol = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = columnList.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if(node.left != null){
                queue.add(node.left);
                columnList.add(col-1);
                minCol = Math.min(minCol, col-1);
            }
            if (node.right != null){
                queue.add(node.right);
                columnList.add(col+1);
                maxCol = Math.max(maxCol, col+1);
            }
        }
        for(int i = minCol; i<=maxCol;i++){
            result.add(map.get(i));
        }
        return result;
    }
}
