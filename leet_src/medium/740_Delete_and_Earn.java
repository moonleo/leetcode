class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        int[] times = new int[10001];
        for(int i: nums) {
            times[i] ++;
        }
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = times[1];
        int max = 0;
        for(int i = 2; i < 10001; i ++) {
            if(times[i] == 0) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = max(dp[i-2] + times[i] * i, dp[i- 1]);
                max = max(max, dp[i]);
            }
        }
        return max;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
