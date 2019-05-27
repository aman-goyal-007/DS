package greedy;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/longest-increasing-subsequent/problem
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3,10,2,1,20};
        lis(arr);

    }

    private static void lis(int[] arr){
        int length = arr.length;
        List<Integer>[] solArr = new ArrayList[length];
        int max = 1;
        for(int i=0;i<length;i++)solArr[i] = new ArrayList<>();
        solArr[0].add(arr[0]);
        for(int i=1;i<length;i++){
            for( int m=0;m<i;m++){
                if(arr[m]<arr[i] && solArr[i].size()<solArr[m].size()+1){
                    solArr[i]=solArr[m];
                }
            }
            solArr[i].add(arr[i]);
            max = Integer.max(max, solArr[i].size());
        }
        System.out.println(max);
    }
}
