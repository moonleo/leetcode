package leet.medium;

/**
 * No.64 Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
 *
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(new MinimumPathSum().minPathSum(grid));
	}
	
	public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for(int i=1; i<grid[0].length; i++) {
        	path[0][i] = path[0][i-1] + grid[0][i];
        }
        for(int j=1; j<grid.length; j++) {
        	path[j][0] = path[j-1][0] + grid[j][0];
        }
        for(int i=1; i<grid.length; i++) {
        	for(int j=1; j<grid[0].length; j++) {
        		path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
        	}
        }
		return path[grid.length-1][grid[0].length-1];
    }

}
