package misc;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        findSubSets(new int[]{1,2,3});
    }

    private static void findSubSets(int[] arr){
        List<List<Integer>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        for(int num : arr){
            int n = subSets.size();
            for(int i = 0;i<n ;i ++){
                List<Integer> set = new ArrayList<>(subSets.get(i));
                set.add(num);
                subSets.add(set);

            }
        }
        subSets.stream().forEach(System.out::println);
    }
}
