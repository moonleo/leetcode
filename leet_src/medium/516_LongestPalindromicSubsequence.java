class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                if (arr[i] == arr[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                }
            }
        }
        return dp[0][len-1];
    }
}
