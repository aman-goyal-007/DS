package hackersrank;

import java.util.Arrays;

public class MaximumCoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{9, 6, 5, 1};
        solve(coins,coins.length,11);

    }

    private static void solve(int[] coins, int max,int change){
        int[] changeArr = new int[change+1];
        Arrays.fill(changeArr,Integer.MAX_VALUE);
        changeArr[0]=0;
        for(int i=1;i<=change;i++){
            for(int a=0;a<max;a++){
                if(coins[a]<=i){
                    int subSolution = changeArr[i-coins[a]];
                    if(subSolution != Integer.MAX_VALUE && subSolution+1<changeArr[i])
                        changeArr[i] = subSolution+1;
                }
            }
        }
        System.out.println(changeArr[change]);
    }

}
