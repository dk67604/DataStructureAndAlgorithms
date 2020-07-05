package main.java.datastructure;

/*
https://www.youtube.com/watch?v=CWDQJGaN1gY
https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 */

public class BinaryIndexedTree {
    int[] nums;
    int[] BIT;
    int n;

    public BinaryIndexedTree(int[] nums){
        this.nums = nums;
        n = nums.length;
        BIT = new int[n+1];
        //Build BIT
        for (int i =0;i<n;i++){
            init(i,nums[i]);
        }

    }

    private void init(int i,int val){
        i++;
        while (i<=n){ // till i reaches at the end of array
            BIT[i]+=val;
            i+=(i&-i);//get next position for update the prefix sum
        }
    }
    public void update(int i,int val){
        int diff = val - nums[i];
        nums[i] = val;
        init(i,diff);
    }

    public int getSum(int i){
        int sum =0;
        i++;
        while (i>0){
            sum+=BIT[i];
            i-=(i&-i); //get parent
        }
        return sum;
    }

    public int sumRange(int i,int j){
        return getSum(j) - getSum(i-1);
    }
}
