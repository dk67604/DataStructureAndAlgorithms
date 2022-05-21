package main.java.topcodingquestion.recursion;

public class TowerOfHanoi {
    public static void toh(int n, int t1id, int t2id, int t3id){
        if (n==0) return;
        toh(n-1, t1id,t3id,t2id); //will print the instruction to move n-1 disks from tower 1 to tower 3 using tower 2
        System.out.println(n + "[" + t1id + " -> " + t2id + "]") ;
        toh(n-1, t3id,t2id,t1id);
    }

    public static void main(String[] args) {
        toh(3,10,11,12);
    }
}
