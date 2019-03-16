package hackersrank;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class RealEstateBroker {
    public static void main(String[] args) {
        int[][] clients = new int[3][3];
        int[][] houses = new int[3][3];
        clients[0][0] = 5;
        clients[0][1] = 110;
        clients[1][0] = 9;
        clients[1][1] = 500;
        clients[2][0] = 20;
        clients[2][1] = 400;
        houses[0][0] = 10;
        houses[0][1] = 100;
        houses[1][0] = 2;
        houses[1][1] = 200;
        houses[2][0] = 30;
        houses[2][1] = 300;
        int totalClients = clients.length;
        int totalHouses = clients.length;
        int totalForMaxFlow = totalClients+totalHouses+2;
        int[][] connectedFlow = new int[totalForMaxFlow][totalForMaxFlow];
        for(int i=0;i<totalClients;i++){
            connectedFlow[0][i+1]=1;
        }
        for(int i=0;i<totalHouses;i++){
            connectedFlow[totalClients+i+1][totalForMaxFlow-1]=1;
        }
        for(int i=0;i<totalClients;i++){
            int minArea = clients[i][0];
            int maxPrice = clients[i][1];
            for(int m=0;m<totalHouses;m++){
                int houseArea = houses[m][0];
                int housePrice = houses[m][1];
                if(houseArea>=minArea && housePrice<=maxPrice){
                    connectedFlow[i+1][totalClients+m+1]=1;
                }
            }
        }
        ford(connectedFlow,0,connectedFlow.length-1);

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
