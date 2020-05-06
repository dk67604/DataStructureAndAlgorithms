package main.java.leetcode;

import java.util.PriorityQueue;

public class QueueNode implements Comparable<QueueNode> {
	
	// this keep track of the array index and value which is required to insert in the
	// min heap
	// Time Complexity nk*logk
 int arr;
 int index;
 int value;
 public QueueNode() {
	 
 }
 public QueueNode(int arr,int index,int value) {
	 this.arr=arr;
	 this.index=index;
	 this.value=value;
 }
@Override
public int compareTo(QueueNode o) {
	if(value>o.value)return 1;
	if(value<o.value) return -1;
	else return 0;
}

public int[] merge(int[][] arrays) {
	PriorityQueue<QueueNode> pq=new PriorityQueue<>();
	int size=0;
	for(int i=0;i<arrays.length;i++) {
		size+=arrays[i].length;
		if(arrays[i].length>0) {
			pq.add(new QueueNode(i, 0, arrays[i][0]));
		}
	}
	int[]result=new int[size];
	for(int i=0;!pq.isEmpty();i++) {
		QueueNode node=pq.poll();
		result[i]=node.value;
		int newindex=node.index+1;
		if(newindex<arrays[node.arr].length) {
			pq.add(new QueueNode(node.arr, newindex, arrays[node.arr][newindex]));
		}
	}
	return result;
}
public static void main(String[] args) {
	QueueNode queueNode=new QueueNode() ;
		
	int[][] arrays=new int[][]{{1, 4, 7},{2, 5, 8},{3, 6, 9}};
	int[] result=queueNode.merge(arrays);
	for(int i:result) {
		System.out.println(i);
	}
}
 
}
