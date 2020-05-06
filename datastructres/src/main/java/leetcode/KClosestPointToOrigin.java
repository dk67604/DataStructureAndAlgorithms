package main.java.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

class PointXY  {
    int x;
    int y;
    Double distance;
    public PointXY(int x,int y){
        this.x = x;
        this.y = y;
        this.distance=getDistance(this.x,this.y);
    }

    public double getDistance(int x,int y){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }


}

class PointComparator implements Comparator<PointXY>{

    @Override
    public int compare(PointXY o1, PointXY o2) {
        return o2.distance.compareTo(o1.distance);
    }
}

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<PointXY> pq = new PriorityQueue<PointXY>(new PointComparator());
        for (int[] p:points){
            pq.offer(new PointXY(p[0],p[1]));
            if(pq.size()>K){
                pq.poll();
            }
        }
        int[][] res=new int[K][2];
        while (K>0){
            PointXY p=pq.poll();
            res[--K]=new int []{p.x,p.y};
        }

        return res;

    }


    public static void main(String[] args) {
        KClosestPointToOrigin kClosestPointToOrigin = new KClosestPointToOrigin();
        int[][] points = new int[][]{{1,3},{-2,2}};
        int K=1;
        kClosestPointToOrigin.kClosest(points,K);
    }
}
