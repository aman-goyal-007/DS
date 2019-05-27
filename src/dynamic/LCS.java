package dynamic;

// Longest common subsequence
public class LCS {
    public static void main(String[] args) {
        char[] arrOne= {'A','G','T','G','A','T','G'};
        char[] arrTwo= {'G','T','T','A','G'};
        solveLCS(arrOne,arrTwo);
    }

    private static void solveLCS(char[] arrOne, char[] arrTwo){

        int[][] solutionArr = new int[arrOne.length+1][arrTwo.length+1];
        int max = 0;

        for(int i = 0;i<arrOne.length;i++){
            for(int j = 0;j<arrTwo.length;j++){
                if(i==0 || j==0) solutionArr[i][j]= 0;
                else if (arrOne[i] == arrTwo[j]) solutionArr[i][j] = solutionArr[i-1][j-1]+1;
                else solutionArr[i][j] = solutionArr[i][j] = Math.max(solutionArr[i-1][j],solutionArr[i][j-1]);
            }
        }

        for(int i=0;i<arrOne.length;i++){
            for(int j=0;j<arrTwo.length;j++){
                System.out.print(solutionArr[i][j]+",");
            }
            System.out.println("");
        }

    }
}
