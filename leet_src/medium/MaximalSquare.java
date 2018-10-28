package leet.medium;

/**
 * No.221 Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square 
 * containing all 1's and return its area. 
 */
public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][]{
				{'1','1','0','1','1'},
				{'1','1','1','0','1'}};
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}
	
	public int maximalSquare(char[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return 0;
        }
        //动态规划
        int[][] maxArea = new int [matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[0][i] == '1') {
                 maxArea[0][i] = 1;
                 max = 1;
            }
        }
        for(int j=0; j<matrix.length; j++) {
            if(matrix[j][0] == '1') {
                maxArea[j][0] = 1;
                max = 1;
            }
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                	//以‘1’为右下角的矩形最大面积
                    maxArea[i][j] = min(maxArea[i-1][j], maxArea[i][j-1], maxArea[i-1][j-1]) + 1;
                    max = Math.max(maxArea[i][j]*maxArea[i][j], max);
                }
            }
        }
        return max;
    }
    
    private int min(int a, int b, int c) {
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }

}
