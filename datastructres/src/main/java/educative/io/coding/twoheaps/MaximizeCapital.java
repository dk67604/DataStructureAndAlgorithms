package main.java.educative.io.coding.twoheaps;

import java.util.PriorityQueue;
/*
1. Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
2. Go through the top projects of the min-heap and filter the projects that can be completed within our available
capital.
3. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit.
4 .Finally, select the top project of the max-heap for investment.
5 .Repeat the 2nd and 3rd steps for the required number of projects.
 */
public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n,(i1,i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n,(i1,i2) -> profits[i2] - profits[i1]);
        // insert all project capitals to a min-heap
        for(int i = 0; i< n;i++){
            minCapitalHeap.offer(i);
        }
        int availableCapital = initialCapital;
        for(int i =0 ; i< numberOfProjects;i++){
            // find all projects that can be selected within the available capital and insert them in a max-heap
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital){
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            // terminate if we are not able to find any project that can be completed within the available capital
            if(maxProfitHeap.isEmpty())
                break;

            availableCapital += profits[maxProfitHeap.poll()];
        }


        return availableCapital;
    }
    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
