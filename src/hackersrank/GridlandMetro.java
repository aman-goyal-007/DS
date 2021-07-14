package hackersrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class GridlandMetro {

	
	  public static void mainaa(String...args) { 
	//	  gridlandMetro(4,4,3,new int[][]{{2,2,3},{3,1,4},{4,4,4}}); 
	//  gridlandMetro(1,5,3,new int[][]{{1,1,2},{1,2,4},{1,3,5}}); 
  }
	 	
	public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new FileReader(new File("C:\\AWS\\aman.txt")));

        String[] nmk = scanner.readLine().split(" ");

        long n = Long.valueOf(nmk[0]).longValue();

        long m = Long.valueOf(nmk[1]).longValue();

        int k = Long.valueOf(nmk[2]).intValue();

        long[][] track = new long[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                long trackItem = Long.valueOf(trackRowItems[j]).longValue();
                track[i][j] = trackItem;
            }
        }

        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        scanner.close();
    }
	
	static long gridlandMetro(long n, long m, int k, long[][] track) {
		long sol = 0;
		if(k==0) {
			return n*m;
		}
		Arrays.sort(track, (long[] entry1,long[] entry2) -> {
			if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          
        });
		
		long prev = -1;
		long[] arr = new long[(int)m];
		for(int i=0;i<k;i++) {
			long row = track[i][0]-1;
			long startCol = track[i][1]-1;
			long endCol = track[i][2]-1;
			
			if(prev != -1 && prev != row) {
				sol += Arrays.stream(arr).filter(abc->abc==1).count();
				arr = new long[(int)m];
			}
			Arrays.fill(arr, (int)startCol, (int)endCol+1, 1l);;
			
			
			prev = row;

		}
		sol += Arrays.stream(arr).filter(abc->abc==1).count();
		return (m*n-sol);

		

    }
}
