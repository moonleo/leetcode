package leet.medium;

/**
 * No.73 Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
//		int[][] matrix = new int[][]{{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
		int[][] matrix = new int[][]{
				{3,5,5,6,9,1,4,5,0,5},
				{2,7,9,5,9,5,4,9,6,8},
				{6,0,7,8,1,0,1,6,8,1},
				{7,2,6,5,8,5,6,5,0,6},
				{2,3,3,1,0,4,6,5,3,5},
				{5,9,7,3,8,8,5,1,4,3},
				{2,4,7,9,9,8,4,7,3,7},
				{3,5,2,8,8,2,2,4,9,8}
		};
		new SetMatrixZeroes().setZeroes(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void setZeroes(int[][] matrix) {
		boolean column = false, row = false;
		
		for(int i=0; i<matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				row = true;
				break;
			}
        }
		
		for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
            	column = true;
            	break;
            }
        }
		
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] ==0 ) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(column) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
