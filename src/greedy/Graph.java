package greedy;

public class Graph {

    int V; // no of vertices
    int E; // no of edges

    Edge[] edge;


    Graph(int noOfVertices, int noOfEdges){
        V = noOfVertices;
        E = noOfEdges;
        edge = new Edge[E];
        for(int i=0;i<E;i++){
            edge[i] = new Edge();
        }
    }

    public void addEdge(int index, int src, int dest, int weight){
        edge[index].src=src;
        edge[index].dest=dest;
        edge[index].weight = weight;
    }

    public void printGraph(){
        for(int i=0;i<edge.length;i++){
            System.out.println(edge[i].src+","+edge[i].dest);
        }
    }
}
 class Edge implements Comparable<Edge>{
    int src,dest, weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }

     @Override
     public boolean equals(Object obj) {
        Edge edge = (Edge)obj;
         return this.src == edge.src && this.dest ==edge.dest;
     }
 }

