package leet.medium;

/**
 * No.48 Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
        if(matrix.length == 0) {
            return ;
        }
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                newMatrix[j][i] = matrix[n-1-i][j];
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
