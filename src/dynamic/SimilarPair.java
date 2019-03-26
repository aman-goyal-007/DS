package dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class SimilarPair {
    static int similar = 0;
    static int[] bit = null;

    public static void main(String[] args) {

        int n=5, k=2;
        int[][] edges = {{3,2},{3,1},{1,4},{1,5}};
        boolean[] root_index = new boolean[n+1];
        Arrays.fill(root_index,true);
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0;i<edges.length;i++){
            list[edges[i][0]] = new ArrayList();
        }
        for(int i=0;i<edges.length;i++){
            list[edges[i][0]].add(edges[i][1]);
            root_index[edges[i][1]]=false;
        }
        int root = -1;
        for(int i=1;i<=n;i++){
            if(root_index[i]){
                root=i;
                break;
            }
        }
        bit = new int[n+1];
        dfs(list,root,k,n);
        System.out.println("hello "+similar);
    }

    private static void dfs(ArrayList<Integer>[] list,int index,  int k, int n){
        similar += getSumInRange(Math.max(1,index-k), Math.min(n,index+k));
        bitUp(n,index,1);
        if(list[index] !=null) {
            for (int i = 0; i < list[index].size(); i++) {
                dfs(list, list[index].get(i), k, n);
            }
        }
        bitUp(n,index,-1);

    }

    private static int getSum(int index){
        int sum=0;
        while(index>0){
            sum += bit[index];
            index = index - (index & -index);
        }
        return sum;
    }
    private static int getSumInRange(int start, int end){
        return getSum(end) - getSum(start-1);
    }

    private static void bitUp(int n,int index, int diff){
        while(index<=n){
            bit[index]+=diff;
            index += (index & -index);
        }
    }

}
