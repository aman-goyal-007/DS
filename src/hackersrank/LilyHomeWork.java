package hackersrank;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/lilys-homework/problem
public class LilyHomeWork {
    public static void main(String[] args) {
        int[] arr = {3,4,2,5,1};
        int length = arr.length;
        int[] sorted = Arrays.copyOf(arr,length);
        int ans = 0;

        Arrays.sort(sorted);
        int[] reversed = IntStream.of(sorted).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray();
        int a = solve(length,arr,sorted);
        int b = solve(length,arr,reversed);
        System.out.println(Math.min(a,b));
    }


    private static int solve(int length,int[] arr, int[] sorted){
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++) {
            int element = arr[i];
            map.put(element,i);
        }
        for(int i=0;i<length;i++){
            int element = sorted[i];
            int index2 = map.get(element);
            if(index2!=i) {
                int value = arr[i];
                map.put(value, index2);
                map.put(element, i);
                ans++;
            }

        }
        return ans;
    }
}
