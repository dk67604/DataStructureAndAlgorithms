package main.java.dsa_2024.datastructures;

public class BinaryIndexedTree {

    /*
     *
     To get parent
     1) 2's complement to get minus of index
     2) AND this with index
     3) Subtract that from index
     */
    public int getParent(int index){
        return index - (index & -index);
    }

    public int getNext(int index){
        return index + (index & -index);
    }

    public void updateBinaryTree(int[] indexTree, int num, int index){
        while (index < indexTree.length) {
            indexTree[index] += num;
            index = this.getNext(index);
        }
    }

    public int[] createTree(int[] nums){
        int[] indexTree = new int[nums.length + 1];
        for(int i = 1 ; i< nums.length + 1; i++){
            this.updateBinaryTree(indexTree, nums[i-1], i);
        }
        return indexTree;
    }
    // Start from index+1 if you want prefix sum 0 to index. Keep adding value
    // till you reach 0
    public int getSum(int[] indexTree, int index){
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += indexTree[index];
            index = this.getParent(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree();
        int [] nums = {1,2,3,4,5,6,7};
        int[] indexTree = binaryIndexedTree.createTree(nums);
        assert 1 == binaryIndexedTree.getSum(indexTree, 0);
        assert 3 == binaryIndexedTree.getSum(indexTree, 1);
        assert 6 == binaryIndexedTree.getSum(indexTree, 2);
        assert 10 == binaryIndexedTree.getSum(indexTree, 3);
        assert 15 == binaryIndexedTree.getSum(indexTree, 4);
        assert 21 == binaryIndexedTree.getSum(indexTree, 5);
        assert 28 == binaryIndexedTree.getSum(indexTree, 6);

        // test range sum
        int left = 3;
        int right = 5;
        int ans = binaryIndexedTree.getSum(indexTree, right) - binaryIndexedTree.getSum(indexTree, left -1);
        assert 15 == ans;
    }
}
