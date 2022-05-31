package main.java.datastructure;



import java.util.ArrayList;
import java.util.List;

public class NAryTree {
    public int val;
    public NAryTree prev;
    public NAryTree next;
    public List<NAryTree> children;
    public NAryTree(int val){
        this.val = val;
        this.children = new ArrayList<>();
    }
    public NAryTree(){
        this.children = new ArrayList<>();
    }
}
