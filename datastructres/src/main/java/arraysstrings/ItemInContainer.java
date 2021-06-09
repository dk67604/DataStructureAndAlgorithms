package main.java.arraysstrings;

import java.util.ArrayList;
import java.util.List;

public class ItemInContainer {
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        /**
         * STEP1
         * The idea is to create a memo list which stores the total number of items upto the ith index.
         *
         * STEP2
         * Once this list is created, iterate over all the [startIndices,endIndices] pair, removing the leading
         * '*' , both from the left and right side. These are the items which are not enclosed within the containers.
         * This will yield start and end index withing which, the number of items have to be obtained. For this,
         * memo list is used which is created in STEP1 1.
         */
        int[] itemCountMem = new int[s.length()];
        int itemCount = 0;
        /**
         * Crete memo list
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                itemCountMem[i] = itemCount;
            } else {
                itemCount++;
            }
        }//for


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < endIndices.size(); i++) {
            int startIndex = startIndices.get(i) - 1;
            int endIndex = endIndices.get(i) - 1;

            /**
             * Remove leading * from left to right
             */
            while (startIndex < endIndex) {
                if (s.charAt(startIndex) != '|') startIndex++;
                else break;
            }

            /**
             * Remove leading * from right to left
             */
            while (startIndex < endIndex) {
                if (s.charAt(endIndex) != '|') endIndex--;
                else break;
            }

            //Add the number of items to the res list.
            res.add(itemCountMem[endIndex] - itemCountMem[startIndex]);
        }//for

        return res;

    }
}
