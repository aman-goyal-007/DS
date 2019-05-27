package greedy;

import java.util.Arrays;

/*
A spanning tree is tree where all nodes are connected some how.
MST is spanning tree with minimum weight
Used in network design, travelling salesman problem, cluster analysis

We are creating MST using Union and Find algorithm (which is used to detect cycle) which is fast when it comes to detect cycle
 */
public class KruskalMinimumSpanningTree {
    public static void main(String[] args) {
        Graph graph = new Graph(9,14);
        graph.addEdge(0,0,1,4);
        graph.addEdge(1,1,2,8);
        graph.addEdge(2,2,3,7);
        graph.addEdge(3,3,4,9);
        graph.addEdge(4,4,5,10);
        graph.addEdge(5,5,6,2);
        graph.addEdge(6,6,7,1);
        graph.addEdge(7,7,0,8);
        graph.addEdge(8,1,7,11);
        graph.addEdge(9,2,8,2);
        graph.addEdge(10,8,6,6);
        graph.addEdge(11,3,5,14);
        graph.addEdge(12,7,8,7);
        graph.addEdge(13,2,5,4);

        createMSTUsingUnionAndFind(graph);

    }

    private static void createMSTUsingUnionAndFind(Graph graph){
        Arrays.sort(graph.edge);
        Edge[] edgeArr = graph.edge;
        int parent[]  = new int[graph.V];

        for(int i=0;i<graph.V;i++)parent[i]=i;


        for(int i =0;i<edgeArr.length;i++){
            int x = find(parent,edgeArr[i].src);
            int y = find(parent,edgeArr[i].dest);
            if(x == y) {
                edgeArr[i].src = -1;
                edgeArr[i].dest = -1;
            }
            union(parent,x,y);
        }
        graph.printGraph();

    }

    private static int find(int[] parent, int node) {
        if(parent[node]==node)
            return node;
        return
                find(parent,parent[node]);
    }

    private static void union(int[] parent, int src, int dest){
        int x = find(parent,src);
        int y = find(parent,dest);
        if(x==src)
            parent[y] = x;
        else
            parent[x] = y;
    }



}
