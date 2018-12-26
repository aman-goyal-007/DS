package dynamic;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        char[] firstStr = {'A','B','C','D','G','H'};
        char[] secondStr = {'A','E','D','F','H','R'};
        printLCS(firstStr,secondStr);
    }

    public static void printLCS(char[] firstStr, char[] secondStr){
        int max = 0;
        int[][] solutionMatrix = new int[firstStr.length+1][secondStr.length+1];
        for(int i=1;i<=firstStr.length;i++){
            for(int j=1;j<=secondStr.length;j++){
                if(firstStr[i-1] == secondStr[j-1]) solutionMatrix[i][j] = solutionMatrix[i-1][j-1]+1;
                else solutionMatrix[i][j] = Math.max(solutionMatrix[i-1][j],solutionMatrix[i][j-1]);

                if(max<solutionMatrix[i][j]){
                    max = solutionMatrix[i][j];
                    System.out.print(firstStr[i-1]);
                }

            }
        }

    }
}
