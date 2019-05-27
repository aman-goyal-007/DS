package hackersrank;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
/*
 * Count cycle.https://www.includehelp.com/java-programs/minimum-swaps-required-to-sort-an-array.aspx
 * 
 */
public class MinimumSwapsAscending {

	public static void main(String...args) {
		int[] arr = {2,4,5,1,3};
		int swap = 0;
		boolean[] visited = new boolean[arr.length];
		for(int i = 0;i<arr.length;i++) {
			int j=i;
			int cycle = 0;
			while(!visited[j]) {
				visited[j]=true;
				j = arr[j]-1;
				cycle++;
			}
			if(cycle != 0)
				swap += cycle-1;
		}
		System.out.println(swap);
		
	}
}