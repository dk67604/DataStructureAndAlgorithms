package main.java.leetcode;
import java.io.*;
import java.util.*;

public class MinimizePermutation {

    class Pair{
                String key;
                int value;
                public Pair(String key,int value){
                    this.key = key;
                    this.value = value;
                }

                public String getKey() {
                    return key;
                }

                public int getValue() {
                    return value;
                }
            }
            int minOperations(int[] arr) {
                //convert all the array number into a string as start;
                //sort the arr again an convert into a string again as dest;
                //use bfs to find the path from start to destination;
                //the queue will store the new string and the number of steps; beginning step is 0;
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < arr.length; i++)
                {
                    sb.append(arr[i]);
                }
                String start = sb.toString();
                Arrays.sort(arr);
                sb = new StringBuilder();
                for(int i = 0; i < arr.length; i++)
                {
                    sb.append(arr[i]);
                }
                String dest = sb.toString();
                Queue<MinimizePermutation.Pair> queue = new LinkedList<>();
                queue.offer(new MinimizePermutation.Pair(start, 0));
                HashSet<String>set = new HashSet<>();
                set.add(start);
                if (start.equals(dest)) {
                    return 0;
                }
                while(!queue.isEmpty())
                {
                    MinimizePermutation.Pair node = queue.poll();
                    String startNode = node.getKey();
                    if(startNode.equals(dest))
                    {
                        return node.getValue();
                    }
                    for(int i = 1 ; i < arr.length; i++)
                    {
                        for(int j = 0; j < i; j++)
                        {

                            String reverse = startNode.substring(j, i+1);
                            StringBuffer sbr = new StringBuffer(reverse);

                            sbr.reverse();
                            reverse = sbr.toString();
                            String newNode="";
                            if (j>0)
                                newNode = startNode.substring(0,j);
                            if (i+1< arr.length)
                                newNode += reverse + startNode.substring(i+1);
                            else
                                newNode += reverse;
                            if (!set.contains(newNode))
                            {
                                set.add(newNode);
                                queue.offer(new MinimizePermutation.Pair(newNode,node.getValue()+1));
                            }
                        }
                    }
                }
                return -1;
        }


    public static void main(String[] args) {
        int [] arr = {3,1,2};
        MinimizePermutation minimizePermutation = new MinimizePermutation();
        System.out.println(minimizePermutation.minOperations(arr));
    }
}
