package hackersrank;

/*
https://www.hackerrank.com/challenges/crush/problem
Given a range[, ] and a value we need to add to all the numbers whose indices are in the range from [,
].
We can do an O(
) update by adding to index and add to index
.
Doing this kind of update, the
number in the array will be prefix sum of array from index 1 to i because we are adding to the value at index and subtracting from the value at index and taking prefix sum will give us the actual value for each index after
operations .
So, we can do all
updates in O(m) time. Now we have to check the largest number in the original array. i.e. the index i such that prefix sum attains the maximum value.
We can calculate all prefix sums as well as maximum prefix sum in O(n) time which will execute in time.
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        int n=5;
        int[][] queries={{2,6,8},{3,5,7},{1,8,1},{5,9,15}};
        long[] arr = new long[n+1];
        for(int i=0;i<queries.length;i++){
            int from = queries[i][0];
            int to = queries[i][1];
            int add = queries[i][2];
            arr[from]+=add;
            if(to+1<=n)
                arr[to+1]-=add;
        }
        long max = 0;
        long x=0;
        for(int i=0;i<=n;i++){
            x+=arr[i];
            max=Math.max(x,max);
        }
        System.out.println(max);
    }
}