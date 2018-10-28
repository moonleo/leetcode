package leet.medium;

/**
 * No.304 Range Sum Query 2D - Immutable
 * Given a 2D matrix matrix, find the sum of the elements 
 * inside the rectangle defined by its upper left corner 
 * (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},
				{4,1,0,1,7},{1,0,3,0,5}};
		RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(matrix);
		System.out.println(r.sumRegion(1, 1, 2, 2));
	}
	
	private int[][] dp;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix.length == 0) {
            dp = new int[0][0];
        } else {
        	 dp = new int[matrix.length+1][matrix[0].length+1];
             dp[1][1] = matrix[0][0];
             for(int i=1; i<matrix[0].length; i++) {
                 dp[1][i+1] = dp[1][i]+matrix[0][i];
             }
             if(matrix.length > 1) {
 	            for(int j=1; j<matrix.length; j++) {
 	                dp[j+1][1] = dp[j][1]+matrix[j][0];
 	            }
 	            for(int i=2; i<=matrix.length; i++) {
 	                for(int j=2; j<=matrix[0].length; j++) {
 	                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i-1][j-1];
 	                }
 	            }
             }
        }
        /*for(int i=0; i<dp.length; i++) {
        	for(int j=0; j<dp[0].length; j++) {
        		System.out.print(dp[i][j]+"\t");
        	}
        	System.out.println();
        }*/
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] -dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }

}
