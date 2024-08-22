package main.java.dsa_2024.algorithms;

public class FindDuplicateNumber {
   public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        int slow2 = 0;
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2) ;

        return slow2;

   }


}
