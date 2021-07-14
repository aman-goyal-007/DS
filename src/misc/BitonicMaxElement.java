package misc;
// Solved using modified binary search
public class BitonicMaxElement {
    public static void main(String[] args) {
        maxInBitonic(new int[]{1,2,3,4,4,3,2,1});
    }

    private static void maxInBitonic(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int middle = (start+end)/2;
            if(arr[middle+1]<arr[middle]){
                end = middle;
            }else{
                start = middle+1;
            }
        }
        System.out.println(arr[start]);
    }
}
