class Solution {
    public int minFallingPathSum(int[][] A) {
        int length = A.length;
        if(length == 1) {
            return A[0][0];
        }
        int[] dp = new int[length];
        int[] curLine;
        for(int i = 0; i < length; i ++) {
            curLine = new int[length];
            for(int j = 0; j < length; j ++) {
                if(j == 0) {
                    curLine[j] = A[i][j] + min(dp[j], dp[j + 1]);
                } else if(j == length - 1) {
                    curLine[j] = A[i][j] + min(dp[j - 1], dp[j]);
                } else {
                    curLine[j] = A[i][j] + min(dp[j - 1], dp[j], dp[j + 1]);
                }
            }
            System.arraycopy(curLine, 0, dp, 0, length);
        }
        return min(dp);
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }

    private int min(int a, int b, int c) {
        int tmp = min(a, b);
        return tmp > c ? c : tmp;
    }

    private int min(int[] arr) {
        int tmp = 101;
        for(int i: arr) {
            if(i < tmp) {
                tmp = i;
            }
        }
        return tmp;
    }
}
