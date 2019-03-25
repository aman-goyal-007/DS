package greedy;
/*

Algorithm to find cycle in a graph

Union by rank and path compression in which is implemented using array in which parent will change itself to the top.
Though we are not merging 2 disjoint tree until we have a link.

*/
public class UnionFindDetectCycle {
    public static void main(String[] args) {
        Graph graph = new Graph(5,5);
        graph.addEdge(0,0,1,0);
        graph.addEdge(1,0,2,0);
        graph.addEdge(2,2,3,0);
        graph.addEdge(3,2,4,0);
        graph.addEdge(4,3,4,0);
        System.out.println(isCyclicGraph(graph));
    }

    private static boolean isCyclicGraph(Graph graph){
        int[] parent = new int[graph.V];
        for(int i=0;i<graph.V;i++)parent[i]=i;

        for(int i=0;i<graph.E;i++){
            int x = find(parent,graph.edge[i].src);
            int y = find(parent,graph.edge[i].dest);
            if(x==y) return true;
            union(parent,x,y);

        }
        return false;
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

    static void print(int []arr){
        for(int i:arr)
            System.out.print(i+",");
        System.out.println();
    }
}
