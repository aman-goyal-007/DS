package hackersrank;

import java.util.Arrays;
import java.util.Collections;


public class LargestPermutation {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,2,1,3};
        Integer[] dupArr = new Integer[arr.length];
        int i=0;
        for(int a:arr){
            dupArr[i++]=a;
        }
        Arrays.sort(dupArr, Collections.reverseOrder());
        int swaps = 0;
        i=0;
        while(swaps<k && i<arr.length){
            int element = dupArr[i];
            int index = -1;
            for(int j=i;j<arr.length;j++){
                if(arr[j]==element){
                    index = j;
                    break;
                }
            }
            int temp = arr[i];
            if(temp != element) {
                arr[index] = temp;
                arr[i] = element;
                swaps++;
            }
            i++;

        }
        for( i=0;i<arr.length;i++) System.out.println(arr[i]);
    }

}
