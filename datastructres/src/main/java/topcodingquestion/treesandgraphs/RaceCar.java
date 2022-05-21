package main.java.topcodingquestion.treesandgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class RaceCar {
    class Node{
        int position;
        int speed;
        public Node(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int distance = 0;
        Node start = new Node(0,1);
        queue.add(start);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i =0 ; i< levelSize; i++){
                Node current = queue.poll();
                if(current.position == target)
                    return distance;
                //When A
                int nextPosition = current.position + current.speed;
                int nextSpeed = current.speed*2;
                if(!visited.contains(nextPosition+"," + nextSpeed) && Math.abs(target - nextPosition) < target){
                    visited.add(nextPosition+"," +nextSpeed);
                    queue.add(new Node(nextPosition, nextSpeed));
                }
                //When R
                nextPosition = current.position;
                nextSpeed = current.speed >0 ? -1 : 1;
                if(!visited.contains(nextPosition+"," + nextSpeed) && Math.abs(target - nextPosition) < target){
                    visited.add(nextPosition+"," +nextSpeed);
                    queue.add(new Node(nextPosition, nextSpeed));
                }

            }
            distance++;
        }
        return distance;
    }
}
