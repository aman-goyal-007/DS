package hackersrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClimbingTheLeaderboard {

	public static void main(String...args) {
		climbingLeaderboard(new int[] {100,90,90,80,75,60},new int[]{50,65,77,90,102});
	}
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] sol = new int[alice.length];
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for( int i : scores) {
        	if(i != prev) {
        		list.add(i);
        	}
        	prev = i;
        }
        Comparator<Integer> comp = (o1,o2)-> (o2.compareTo(o1));
        int i=0;
        for(int m : alice) {
        	int j = Collections.binarySearch(list, m, comp);
        	if(j < 0 ) {
        		j = -j-1;
        	}
        	sol[i++] = j+1;
        }
        Arrays.stream(sol).forEach(System.out::println);
        
        return sol;

	}
}
