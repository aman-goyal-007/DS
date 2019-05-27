package dynamic;

public class KnapSack {
    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int  maxWeightOfKnapsack = 50;
        solveKnapsack(value,weight,maxWeightOfKnapsack);
    }

    public static void solveKnapsack(int[] valueOfEachWeight, int[] weights, int maxWeight){
        int[][] solutionArr = new int[weights.length+1][maxWeight+1];
        for(int i=0;i<=weights.length;i++){
            for(int j=0;j<=maxWeight;j++){
                if(i==0 ||j ==0) solutionArr[i][j]=0;
                else if(weights[i-1] <= j){
                    solutionArr[i][j] = Integer.max(valueOfEachWeight[i-1]+solutionArr[i-1][j-weights[i-1]],solutionArr[i-1][j]);
                }else
                    solutionArr[i][j] = solutionArr[i-1][j];
            }
        }
        System.out.println(solutionArr[weights.length][maxWeight]);
    }
}
