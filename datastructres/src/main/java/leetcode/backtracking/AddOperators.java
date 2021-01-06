package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long prevOperand){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long currOperand = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + currOperand, num, target, i + 1, currOperand, currOperand);
            }
            else{
                    helper(rst, path + "+" + currOperand, num, target, i + 1, eval + currOperand , currOperand);

                helper(rst, path + "-" + currOperand, num, target, i + 1, eval -currOperand, -currOperand);

                    helper(rst, path + "*" + currOperand, num, target, i + 1, eval - prevOperand + prevOperand*currOperand, prevOperand * currOperand );
            }
        }
    }

    public static void main(String[] args) {
        String s = "232";
        AddOperators addOperators = new AddOperators();
        System.out.println(Arrays.toString(addOperators.addOperators(s,8).toArray()));
    }
}
