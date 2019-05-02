class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null) {
            return true;
        }
        int len1 = s.length();
        int len2 = t.length();
        //dp[i][j] means does t[0, j] contains s[0, i]
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        //null contains null
        dp[0][0] = true;
        //null does not contains any string
        for(int i = 1; i <= len1; i ++) {
            dp[i][0] = false;
        }
        //any string contains null
        for(int j = 1; j <= len2; j ++) {
            dp[0][j] = true;
        }
        for(int i = 1; i <= len1; i ++) {
            for(int j = i; j <= len2; j ++) {
                //if s[i-1] == t[j-1]
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //if t[0, j-1] contains s[0, i], then t[0, j] does contain s[0, i]
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}
