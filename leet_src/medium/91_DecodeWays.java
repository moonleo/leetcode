class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i ++) {
            char c = s.charAt(i-1);
            char p = s.charAt(i-2);
            if (c == '0') {
                if (p == '1' || p == '2') {
                    dp[i] = dp[i-2];
                } else {
                    return 0;
                }
            } else if (c > '6' && c <= '9') {
                if (p == '1') {
                    dp[i] = dp[i-1] + dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            } else if (p == '1' || p == '2') {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
