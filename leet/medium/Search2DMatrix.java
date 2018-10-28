package leet.medium;

/**
 * No.74 Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties: 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		//从左下角开始搜索
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(target == matrix[i][j]) {
                return true;
            } else if(target > matrix[i][j]) {
                j ++;
            } else {
                i --;
            }
        }
        return false;
    }
}
