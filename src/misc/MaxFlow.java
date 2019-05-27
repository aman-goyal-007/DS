package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Ford Fulkerson
public class MaxFlow {

    public static void main(String[] args) {
        int nodes = 6;
        int[][]graph = new int[6][6];
        graph[0][1] = 16;
        graph[0][2] = 13;
        graph[1][2] = 10;
        graph[1][3] = 12;
        graph[2][1] = 4;
        graph[2][4] = 14;
        graph[3][2] = 9;
        graph[3][5] = 20;
        graph[4][3] = 7;
        graph[4][5] = 4;
        ford(graph,0,5);

    }

    private static void ford(int[][] graph, int source, int sink){
        int nodes = graph.length;
        int[][] residual = new int[nodes][nodes];
        for(int i=0;i<nodes;i++) residual[i]=Arrays.copyOf(graph[i],nodes);
        int[] parent = new int[nodes];
        Arrays.fill(parent,-1);
        int maxFlow = 0;
        while(bfs(source,sink,residual,parent)){
            int flowInPath = Integer.MAX_VALUE;

            for(int vertex = sink; vertex != source;vertex = parent[vertex]){
                int parentNode = parent[vertex];
                flowInPath = Math.min(flowInPath,residual[parentNode][vertex]);
            }

            for(int vertex = sink; vertex != source;vertex = parent[vertex]){
                int parentNode = parent[vertex];
                residual[parentNode][vertex] -= flowInPath;
                residual[vertex][parentNode] += flowInPath;

            }
            Arrays.fill(parent,-1);
            maxFlow += flowInPath;

        }

        System.out.println(maxFlow);
    }

    private static boolean bfs(int source, int destination,int[][] graph, int[] parent){
        int length = graph.length;
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int element = queue.peek();
            int[] connected = graph[element];
            for(int i = 0;i<connected.length;i++){
                if(connected[i]>0 && !visited[i]){
                    queue.add(i);
                    parent[i] = element;
                }
            }
            visited[element]=true;
            queue.poll();
        }
        return visited[destination];

    }
}
