package misc;

/*
Sorted Array
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        findPairForGivenSum(new int[]{1,2,3,4,6},6);
    }

    private static void findPairForGivenSum(int[] arr, int sum){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int currentSum = arr[start]+arr[end];
            if(currentSum == sum){
                System.out.println(start+","+end);
                break;
            }else if(currentSum<sum){
                start++;
            }else{
                end--;
            }
        }
    }
}
