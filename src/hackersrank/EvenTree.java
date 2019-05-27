package hackersrank;

import java.util.LinkedList;
import java.util.List;


public class EvenTree {
    static int answer = 0;
    public static void main(String[] args) {
        int t_nodes= 10;
        int t_edges=9;
        List<Integer>[] graph = new LinkedList[t_nodes+1];
        for(int i=0;i<=t_nodes;i++){
            graph[i] = new LinkedList<>();
        }
        /* For Hacker's Rank Page
        for(int i=0;i<t_from.size();i++){
            graph[t_from.get(i)].add(t_to.get(i));
            graph[t_to.get(i)].add(t_from.get(i));
        }
         */
        graph[2].add(1);
        graph[1].add(2);
        graph[3].add(1);
        graph[1].add(3);
        graph[4].add(3);
        graph[3].add(4);
        graph[5].add(2);
        graph[2].add(5);
        graph[6].add(1);
        graph[1].add(6);
        graph[7].add(2);
        graph[2].add(7);
        graph[8].add(6);
        graph[6].add(8);
        graph[9].add(8);
        graph[8].add(9);
        graph[10].add(8);
        graph[8].add(10);
        boolean[] visited = new boolean[t_nodes+1];
        dfs(graph,visited,1);
        System.out.println(answer);
    }

    public static int dfs(List<Integer>[] graph, boolean[] visited, int index){
        int currentComponentNode = 0;
        visited[index] = true;
        for(int i=0;i<graph[index].size();i++){
            int node = graph[index].get(i);
            if(!visited[node]){
                int subTreeNodeCount = dfs(graph,visited,node);
                if(subTreeNodeCount%2 == 0){
                    answer++;
                }else{
                    currentComponentNode+=subTreeNodeCount;
                }
            }
        }

        return currentComponentNode+1;
    }

}
