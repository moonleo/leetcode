class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        dp[0] = 0;
        int dayIndex = 0;
        for(int i = 1; dayIndex < days.length && i < dp.length; i ++) {
            if(i != days[dayIndex]) {
                dp[i] = dp[i-1];
                continue;
            }
            dayIndex ++;
            dp[i] = min(dp[max(0, i - 7)] + costs[1],
                        dp[max(0, i - 30)] + costs[2],
                        dp[max(0, i - 1)] + costs[0]);
        }
        return dp[days[days.length - 1]];
    }

    private int min(int a, int b, int c) {
        int tmp = min(a, b);
        return tmp < c ? tmp : c;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
