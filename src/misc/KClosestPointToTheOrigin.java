package misc;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of points in a 2D plane, find K closest points to the origin.
Example: Input: points = [[1,2],[1,3]], K = 1, Output: [[1,2]]
 */
public class KClosestPointToTheOrigin {
    public static void main(String[] args) {
        findClosestPoints(new Point[]{new Point(1,2), new Point(1,3)},1);
    }

    private static void findClosestPoints(Point[] points, int k){
        PriorityQueue<Point> maxHeap = new PriorityQueue<>( (p1,p2) -> p2.distanceFromOrigin()-p1.distanceFromOrigin());
        for(int i=0;i<k;i++){
            maxHeap.add(points[i]);
        }

        for(int i=0;i<k;i++){
            if(points[i].distanceFromOrigin()<maxHeap.peek().distanceFromOrigin()){
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        maxHeap.stream().forEach(System.out::println);
    }
}

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceFromOrigin(){
        return (x^2 * y^2);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
