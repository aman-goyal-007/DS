package misc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayMoreOnesThanZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 0, 2, 1, 1};
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] == 0) ? -1 : 1;

            if (sum == 1) maxLength += 1;
            else if (!map.containsKey(sum)) map.put(sum, i);

            if (map.containsKey(sum - 1) && maxLength < i - map.get(sum - 1))
                maxLength = i - map.get(sum - 1);
        }
        System.out.println(maxLength);
    }
}
