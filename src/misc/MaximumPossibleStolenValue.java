package misc;

// https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
public class MaximumPossibleStolenValue {
    public static void main(String[] args) {
        int[] values= {6,7,1,3,8,2,4};
        int[] dp = new int[values.length];

        dp[0] = values[0];
        dp[1] = Integer.max(values[0],values[1]);

        for(int i=2;i<values.length;i++){
            dp[i] = Math.max(values[i] + dp[i-2],dp[i-1]);
        }
        System.out.println(dp[values.length-1]);




    }
}
