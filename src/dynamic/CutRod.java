package dynamic;

import java.util.Arrays;

public class CutRod {
    public static void main(String...args){
        int[] priceOfEachSize={1,5,8,9};
        int maxLength = 4;
        System.out.println("Max possible value is : "+bottomUpApproach(priceOfEachSize,maxLength));
    }

    public static int bottomUpApproach(int[] priceOfEachSize, int length){
        int min = 0;
        int revenue[] = new int[length+1];
        for(int i=1;i<=length;i++){
            int q = 0;
            for(int j=0;j<i;j++)
                q = Integer.max(q,priceOfEachSize[j]+revenue[i-j-1]);
            revenue[i] = q;
//            for(int abc:revenue) System.out.print(abc+",");
        }
        return revenue[length];
    }

    public static int extendedBottomUpApproach(int[] priceOfEachSize, int length){
        int min = 0;
        int revenue[] = new int[length+1];
        int solutionArray[] = new int[length+1];
        for(int i=1;i<=length;i++){
            int q = 0;
            for(int j=0;j<i;j++){
                if(q<priceOfEachSize[j]+revenue[i-j-1]) {
                    q = priceOfEachSize[j] + revenue[i - j - 1];
                    solutionArray[i] = j;
                }

            }
            revenue[i] = q;
        }
        for(int abc:solutionArray) System.out.print(abc+",");
        System.out.println("");
        return revenue[length];
    }
}
