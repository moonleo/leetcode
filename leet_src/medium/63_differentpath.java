class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        int[][] dp = new int[height][width];
        dp[0][0] = 1;
        boolean flag = false;
        for(int i = 1; i < width; i ++) {
            if(obstacleGrid[0][i] == 1) {
                flag = true;
            }
            if(!flag) {
                dp[0][i] = 1;
            }
        }
        flag = false;
        for(int j = 1; j < height; j ++) {
            if(obstacleGrid[j][0] == 1) {
                flag = true;
            }
            if(!flag) {
                dp[j][0] = 1;
            }
        }
        for(int j = 1; j < width; j ++) {
            for(int i = 1; i < height; i ++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
