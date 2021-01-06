package main.java.educative.io.coding.topkelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element{

    int number;
    int frequency;
    int sequenceNumber;

    public Element(int number,int frequency,int sequenceNumber){
        this.number = number;
        this.frequency = frequency;
        this.sequenceNumber = sequenceNumber;
    }

}
class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2){
        if(e1.frequency != e2.frequency)
            return e2.frequency - e1.frequency;
        //if both the frequency tied then return latest push
        return e2.sequenceNumber - e1.sequenceNumber;
    }
}

class FrequencyStack {
    int sequenceNumber =0;
    Map<Integer,Integer> frequencyMap ;
    PriorityQueue<Element> maxHeap ;

    public FrequencyStack() {
        maxHeap = new PriorityQueue<>(new ElementComparator());
        frequencyMap = new HashMap<>();
    }

    public void push(int x) {
        frequencyMap.put(x,frequencyMap.getOrDefault(x,0)+1);
        maxHeap.add(new Element(x,frequencyMap.get(x),sequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().number;
        if(frequencyMap.get(num) > 1){
            frequencyMap.put(num,frequencyMap.get(num)-1);
        }
        else{
            frequencyMap.remove(num);
        }
        return num;
    }
    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
