package leet.medium;

/**
 * No.200 Number of Islands Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 */
public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(i, j, grid);
				}
			}
		}
		return count;
	}

	public void dfs(int i, int j, char[][] grid) {
		if (i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0)
			return;
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			dfs(i - 1, j, grid);
			dfs(i + 1, j, grid);
			dfs(i, j - 1, grid);
			dfs(i, j + 1, grid);
		} else
			return;
	}
}
