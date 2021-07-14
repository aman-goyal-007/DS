import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution{
	public static void main(String...args) {
		List<List<Integer>> sol = new ArrayList<>();
		sol.add(new ArrayList<Integer>());
		sol.add(new ArrayList<Integer>());
		sol.get(0).add(1);
		sol.get(0).add(2);
		sol.get(1).add(3);
		sol.get(1).add(4);
		findMatrix(sol);
	}
	public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
		List<List<Integer>> sol = new ArrayList<>();
		
		int x = after.size();
		int y = after.get(0).size();
		int[][] copy = new int[x][y];
		
		for(int i=0;i<x;i++) {
			sol.add(new ArrayList<Integer>());
			for(int j=0;j<y;j++) {
				copy[i][j] = after.get(i).get(j);
			}
		}
		int[][] aman = new int[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				int val = copy[i][j];
				if(i==0 && j==0) {
					aman[0][0]=val;
				}else {
					int sum=0;
					for(int m=0;m<=i;m++) {
						for(int n=0;n<=j;n++) {
							sum+=aman[m][n];
						}
						
					}
					aman[i][j]=val-sum;
					System.out.println(aman[i][j]);
				}
			}
		}
		for( int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				sol.get(i).add(aman[i][j]);
				
			}
		}
		return sol;
		

    }
}