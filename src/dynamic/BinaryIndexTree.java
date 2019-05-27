package dynamic;

// https://www.youtube.com/watch?v=v_wj_mOAlig
/*
To make it easy we will use 1-based index. First we will build BIT and see if sum works or not.
You can update any node as well by calling updateBIT api.
 */
public class BinaryIndexTree {
    static int[] bit = null;
    public static void main(String[] args) {
        int[] data = {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};
        int length =data.length;
        bit = new int[length+1];
        constructBIT(data,length);
        System.out.println(getSum(5));
        System.out.println(getSumInRange(2,5));
    }

    private static void constructBIT(int[] data, int length){
        for(int i=0;i<length;i++){
            updateBIT(length,i,data[i]);
        }
    }

    private static void updateBIT(int length,int index, int value){
        index++; // because we are using 1-based index
        while(index <= length){
            bit[index] += value;
            index = index+(index & -index);
        }
    }
    // Get sum from (0 ---> index) range
    private static int getSum(int index){
        int sum=0;
        index++; // because we are using 1-based index
        while(index>0){
            sum += bit[index];
            index = index - (index & -index);
        }
        return sum;
    }
    private static int getSumInRange(int start, int end){
        return getSum(end) - getSum(start-1);
    }
}
