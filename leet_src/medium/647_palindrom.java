class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        //record if s.substring(i,j) is palindrome
        int[][] dp = new int[length][length];
        int count = 0;
        //one char is palindrome
        for(int i = 0; i < length; i ++) {
            dp[i][i] = 1;
            count ++;
        }
        //reverse the ergodic, because some value may be hasn't been init
        for(int i = length - 2; i >= 0; i --) {
            for(int j = length - 1; j >= i + 1 ; j --) {
                if(s.charAt(i) == s.charAt(j)) {
                    if((j - 1 == i) || (i + 1 <= j - 1 && dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        count ++;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return count;
    }
}
