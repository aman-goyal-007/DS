package hackersrank;



// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class ConnectedCellsInGrid {
	public static void main(String...args) {
		connectedCell(new int[][] {
			{1,1,0,0},
			{0,1,1,0},
			{0,0,1,0},
			{1,0,0,0},
			});
	}
	
	 static int connectedCell(int[][] matrix) {
	 	int sol = 0;
	 	
	 	int rowCount = matrix.length;
	 	int columnCount = matrix[0].length;
	 	
	 	for(int i = 0;i<rowCount;i++) {
	 		for(int j=0;j<columnCount;j++) {
	 			sol  = Math.max(sol,  dfs(matrix, i,j ,rowCount,columnCount));
	 		}
	 	}
	 	return sol;
	 }
	 
	 private static int dfs(int[][] matrix, int x, int y, int rowCount, int columnCount) {
		 if(!checkValid(x, y, matrix, rowCount, columnCount)) {
			 return 0;
		 }
		 
		 int count = 1;
		 int copyX ;
		 int copyY ;
		 matrix[x][y] = -1; // markVisited
		 
		 for( int i=-1;i<=1;i++) {
			 for(int j=-1; j <=1;j++) {
				 copyX = x+i;
				 copyY = y+j;
				 count = count+dfs(matrix,copyX,copyY,rowCount, columnCount);
			 }
		 }
		 return count;
		 
	 }
	 
	 private static boolean checkValid ( int x, int y , int[][] matrix, int rowCount, int columnCount) {
		 if(x<0 || y<0 || x>=rowCount || y>= columnCount || matrix[x][y] <1) {
			 return false;
		 } else {
			 return true;
		 }
	 }
}
