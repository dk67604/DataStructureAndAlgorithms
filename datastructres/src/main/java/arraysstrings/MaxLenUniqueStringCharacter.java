package main.java.arraysstrings;

import java.util.HashSet;
import java.util.Set;

public class MaxLenUniqueStringCharacter {
    int result = 0;
    public int permute(String[] nums) {
        generate("",nums,0);
        return result;
    }
    private void generate(String prefix,String[] nums,int currentIndex){
        boolean isUnique = isUniqueChars(prefix);
        if(isUnique){
            result = Math.max(prefix.length(),result);
        }
        if(currentIndex == nums.length || !isUnique){
            return;
        }
        for (int i =currentIndex;i<nums.length;i++){
            generate(prefix +nums[i],nums,currentIndex+1);
        }

    }
    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }


    public static void main(String[] args) {
        String[] array = {"co","dil","ity"};
        MaxLenUniqueStringCharacter stringPermute = new MaxLenUniqueStringCharacter();
        System.out.print(stringPermute.permute(array));
    }
}
