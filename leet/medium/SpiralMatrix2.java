package leet.medium;

/**
 * No.59 Spiral Matrix II
 * Given an integer n, generate a square matrix filled 
 * with elements from 1 to n^2 in spiral order.
 */
public class SpiralMatrix2 {

	public static void main(String[] args) {
		SpiralMatrix2 sm = new SpiralMatrix2();
		int n = 4;
		int[][] matrix= sm.generateMatrix(n);
		for(int i=0; i<n; i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		fillMatrix(matrix, 0, 0, n-1, n-1, 1);
		return matrix;
	}

	private void fillMatrix(int[][] matrix, int lx, int ly, int rx, int ry,
			int start) {
		if (lx > rx) {
			return ;
		}
		if(lx == rx && ly == ry) {
            matrix[lx][ly] = start;
        } 
		//从左向右打印
		for(int i=ly; i<=ry; i++) {
			matrix[lx][i] = start ++;
		}
		//从上向下打印
		for(int i=lx+1; i<=rx; i++) {
			matrix[i][ry] = start ++;
		}
		//从右向左打印
		for(int i=ry-1; i>=ly; i--) {
			matrix[rx][i] = start ++;
		}
		//从下向上打印
		for(int i=rx-1; i>lx; i--) {
			matrix[i][ly] = start ++;
		}
		fillMatrix(matrix, ++lx, ++ly, --rx, --ry, start);
	}

}
