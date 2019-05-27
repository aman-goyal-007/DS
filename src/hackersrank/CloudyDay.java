package hackersrank;

import java.util.*;
import java.util.stream.Collectors;

public class CloudyDay {
    static List<Integer> processed = new ArrayList<>();
    public static void main(String[] args) {
        long[] p={10,1,8,3}, x={4,5,7,2},  y={3,9,3,5}, r={11,10,8,7};
//        long[] p={10,100}, x={5,10},  y={4}, r={1};
        //    long[] p={9,9,1,5,8}, x={1,7,7,11,7},  y={2,3}, r={4,11};
//        long[] p={710968056}, x={648957198},  y={537860869,932700775,322731914,335848765,570747597,145761817}, r={867458069,840476761,699140591,251654375,892806344,860058735};
        TreeMap<Long,Long> cityMap = new TreeMap<>();
        HashMap<Long,Long> cloudMap = new HashMap<>();
        for(int i=0;i<x.length;i++){
            if(cityMap.containsKey(x[i])){
                cityMap.put(x[i],cityMap.get(x[i])+p[i]);
            }else{
                cityMap.put(x[i],p[i]);
            }
        }
        long maxCity = cityMap.keySet().stream().mapToLong(a->a).max().getAsLong();
        for(int i=0;i<r.length;i++){
            if(cloudMap.containsKey(y[i])){
                cloudMap.put(y[i],cloudMap.get(y[i])+r[i]);
            }else{
                cloudMap.put(y[i],r[i]);
            }
        }
        long sunshine = cityMap.values().stream().mapToLong(a->a).sum();
        TreeMap<Long,Long> cloudyCitiesCount = new TreeMap<>();
        for(Map.Entry<Long,Long> entry:cloudMap.entrySet()){
            long min = Math.max(0,entry.getKey()-entry.getValue());
            long max = Math.min(maxCity,entry.getKey()+entry.getValue());
            Set<Long> noSunshine = cityMap.keySet().stream().filter(a->a>=min && a<=max).collect(Collectors.toSet());
            if(noSunshine!=null && !noSunshine.isEmpty()){
                for(long delete:noSunshine) {
                    if(cloudyCitiesCount.containsKey(delete)){
                        cloudyCitiesCount.put(delete,cloudyCitiesCount.get(delete)+1);
                    }else cloudyCitiesCount.put(delete,1l);
                }
            }
        }
        for(long delete:cloudyCitiesCount.keySet()){
            sunshine -= cityMap.get(delete);
        }

        Set<Long> eligibleCities = cloudyCitiesCount.keySet().stream().filter(a->cloudyCitiesCount.get(a)==1).collect(Collectors.toSet());
        long maxRemoval = Integer.MIN_VALUE;
        for(Map.Entry<Long,Long> entry:cloudMap.entrySet()) {
            long min = Math.max(0, entry.getKey() - entry.getValue());
            long max = Math.min(maxCity, entry.getKey() + entry.getValue());
            long sumOfPopulationSunshine = 0;
            Set<Long> noSunshine = cityMap.keySet().stream().filter(a -> a >= min && a <= max).collect(Collectors.toSet());
            if(noSunshine!=null) {
                noSunshine.removeIf(a->!eligibleCities.contains(a));
                for(long cityId:noSunshine){
                    sumOfPopulationSunshine+=cityMap.get(cityId);
                }
            }
            maxRemoval = Math.max(maxRemoval,sumOfPopulationSunshine);
        }
        if(maxRemoval>0) sunshine+=maxRemoval;
        System.out.println(sunshine);

    }
    public static void sol1(){
        long[] p={9,9,1,5,8}, x={1,7,7,11,7},  y={2,3}, r={4,11};
        int maxCity = (int)Arrays.stream(x).max().getAsLong();
        int maxCloud = (int)Arrays.stream(y).max().getAsLong();
        int max = Integer.max(maxCity,maxCloud);
        long[] populationArr = new long[max+1];
        for(int i=0;i<p.length;i++)populationArr[(int)x[i]]+=p[i];
        long[] cloudArray = new long[populationArr.length+1];
        for(int i=0;i<y.length;i++){
            long minIndex = Long.max(0,y[i]-r[i]);
            long maxIndex = Long.min(maxCity,y[i]+r[i]);
            for(long m = minIndex;m<=maxIndex;m++){
                cloudArray[(int)m]+=1;
            }
        }
        long sunshine=0;
        for(long i=0;i<populationArr.length;i++){
            if(populationArr[(int)i]>0 && cloudArray[(int)i]==0)sunshine+=populationArr[(int)i];
        }
        long uncloud = Integer.MIN_VALUE;
        for(int i=0;i<y.length;i++) {
            long minIndex = Long.max(0, y[i] - r[i]);
            long maxIndex = Long.min(maxCity, y[i] + r[i]);
            long uncloudSum = 0;
            for(long m = minIndex;m<=maxIndex;m++){
                if(cloudArray[(int)m]==1){
                    uncloudSum +=   populationArr[(int)m];
                }
            }
            uncloud = Math.max(uncloud,uncloudSum);
        }
        if(uncloud>0){
            sunshine+=uncloud;
        }

        System.out.println("Aman "+sunshine );
    }

}



