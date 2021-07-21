package hackersrank;

import java.util.*;

public class FrequencyQueries {
    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,6));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(1,10));
        queries.add(Arrays.asList(1,10));
        queries.add(Arrays.asList(1,6));
        queries.add(Arrays.asList(2,5));
        queries.add(Arrays.asList(3,2));
        List<Integer> result = freqQuery(queries);
        result.stream().forEach(System.out::println);

    }
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
       Map<Integer,Integer> numberToFreqMap = new HashMap<>();
       Map<Integer,Set<Integer>> freqToNumberMap = new HashMap<>();
        for(List<Integer> query:queries){
            int operation = query.get(0);
            int data = query.get(1);
            int dataInMap = numberToFreqMap.getOrDefault(data,0);

            if(operation == 1){
                numberToFreqMap.put(data,dataInMap+1);
                Set<Integer> set = freqToNumberMap.getOrDefault(dataInMap,new HashSet<>());
                set.remove(data);
                freqToNumberMap.put(dataInMap,set);

                Set<Integer> newSet = freqToNumberMap.getOrDefault(dataInMap+1,new HashSet<>());
                newSet.add(data);
                freqToNumberMap.put(dataInMap+1,newSet);

            }else if(operation == 2 && dataInMap > 0){
                numberToFreqMap.put(data,dataInMap-1);
                Set<Integer> set = freqToNumberMap.getOrDefault(dataInMap,new HashSet<>());
                set.remove(data);
                freqToNumberMap.put(dataInMap,set);

                Set<Integer> newSet = freqToNumberMap.getOrDefault(dataInMap-1,new HashSet<>());
                newSet.add(data);
                freqToNumberMap.put(dataInMap-1,newSet);

            }else if(operation == 3){
                if(freqToNumberMap.containsKey(data) && freqToNumberMap.get(data).size()>0){
                    result.add(1);
                }else{
                    result.add(0);
                }
            }
        }


        return result;
    }






}
