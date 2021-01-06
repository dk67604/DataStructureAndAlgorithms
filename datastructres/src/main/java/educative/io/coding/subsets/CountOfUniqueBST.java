package main.java.educative.io.coding.subsets;

public class CountOfUniqueBST {

    public int numTrees(int n){
        if(n < 1) return 0;
        int [] res = new int[n+1];
        // DP Solution
        // no of bst  = left Bst * right Bst
        //the bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).
        res[0] = res[1]=1;
        for(int i =2;i<=n;i++){
            for(int j=1;j<=i;j++){
                res[i] += res[j-1] * res[i-j];
            }
        }
        return res[n];
    }
    public static void main(String[] args) {
        CountOfUniqueBST ct = new CountOfUniqueBST();
        int count = ct.numTrees(3);
        System.out.print("Total trees: " + count);
    }
}
