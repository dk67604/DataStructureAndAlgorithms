package main.java.topcodingquestion.heaps;



import java.util.Map;
import java.util.PriorityQueue;

class  Pair{
    Character ch;
    int count;

    public Pair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
public class LongestHappyString {
    //Use Max Heap to store the frequencies
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1,p2) -> p2.count - p1.count);
        if(a > 0){
            maxHeap.add(new Pair('a',a));
        }
        if(b > 0){
            maxHeap.add(new Pair('b',b));
        }
        if(c > 0){
            maxHeap.add(new Pair('c',c));
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Pair first = maxHeap.poll();
            if(sb.length() !=0  && sb.charAt(sb.length() -1 ) == first.ch){
                if(maxHeap.isEmpty()){
                    return sb.toString();
                }
                Pair second = maxHeap.poll();//Pull next maximum
                sb.append(second.ch);
                if(second.count - 1 > 0){
                    second.count -=1;
                    maxHeap.add(second);
                }
                maxHeap.add(first);
            }else{
                int addTimes = Math.min(first.count, 2);
                int counter =0;
                while (counter++ < addTimes){
                    sb.append(first.ch);
                }
                if(first.count - addTimes > 0){
                    first.count -= addTimes;
                    maxHeap.add(first);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1,1,7));
    }
}
