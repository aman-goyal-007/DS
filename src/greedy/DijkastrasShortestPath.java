package greedy;

import java.util.*;

/*
This algorithm tells shortest distance of all nodes from given node. In our case from node at index 0
 */
public class DijkastrasShortestPath {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        shortestPath(graph);
    }


    private static void shortestPath(int[][] graphArr){
        int noOfNodes = graphArr.length;
        boolean[] included = new boolean[noOfNodes];
        int[] dist = new int[noOfNodes];

        Arrays.fill(included,false); // no vertex included yet

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i=0;i<noOfNodes;i++){
            int u = minDistance(dist,included);
            included[i] = true;

            for(int m=0;m<noOfNodes;m++){
                if(!included[m] && graphArr[u][m] != 0 && // node not included and edge is there
                        dist[u]!= Integer.MAX_VALUE && dist[u] + graphArr[u][m] <dist[m] // distance is valid and not more than already present length
                ){
                    dist[m] = dist[u] + graphArr[u][m];
                }
            }

        }

        printSolution(dist,dist.length);
    }

    private static int minDistance(int[] dist, boolean[] included) {
        int min = Integer.MAX_VALUE;
        int indexOfMinimum = 0;

        for(int i=0;i<dist.length;i++){
            if(!included[i] && dist[i]<=min){
                min = dist[i];
                indexOfMinimum = i;
            }
        }
        return indexOfMinimum;

    }

    private static void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println("node : "+i+" Distance from given node "+dist[i]);
    }

}
