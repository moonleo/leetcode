package leet.medium;

/**
 * No.240 Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom
 */
public class Search2DMatrix2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		//从右上角的位置开始搜索
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(target == matrix[i][j])
                return true;
            else if(target < matrix[i][j]) {
                j --;
            } else {
                i ++;
            }
        }
        return false;
    }
}
