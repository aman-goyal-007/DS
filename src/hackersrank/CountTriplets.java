package hackersrank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTriplets {
    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l,1l),1l));
        System.out.println(countTriplets(Arrays.asList(1l,1l,1l,1l),1l));
    }
    static long countTriplets(List<Long> arr, long r) {
        long sol = 0;
        Collections.sort(arr);
        Map<Long,Long> rightMap = arr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Long,Long> leftMap = new HashMap<>();
        for(long value : arr){
            long rightCount = 0;
            long leftCount = 0;
            long next = value * r;
            long prev = 0;
            if(value % r == 0){
                prev = value/r;
            }
            long count = rightMap.get(value);
            rightMap.put(value,--count);

            if(rightMap.containsKey(next)){
                rightCount = rightMap.get(next);
            }

            if(leftMap.containsKey(prev)){
                leftCount = leftMap.get(prev);
            }

            sol += (rightCount*leftCount);

            long temp = 0;
            if(leftMap.containsKey(value)){
                temp = leftMap.get(value);
            }
            temp++;
            leftMap.put(value,temp);


        }
        return sol;
    }
}
